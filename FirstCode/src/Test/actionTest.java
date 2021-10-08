package Test;
import java.util.*;
import java.util.Map.Entry;

public class actionTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UserActionHistory myActionHistory = new UserActionHistory();
        //添加各种记录
        for (int i = 1; i < 50; i = i + 2) {
            MyAciton myAcitonTem = new MyAciton("myScan", i, String.valueOf(i));
            myActionHistory.addNewAction(myAcitonTem);
        }
        for (int i = 0; i < 50; i = i + 2) {
            MyAciton myAcitonTem = new MyAciton("myClick", i, String.valueOf(i));
            myActionHistory.addNewAction(myAcitonTem);
        }

        //...test 单个参数......
        List<Action> listSumActions = myActionHistory.getRecentActions(20);
        System.out.println("listSumActions.size(): " + listSumActions.size() + "   | 获得全部类别的前n项值：");
        for (int i = 0; i < listSumActions.size(); i++) {
            Action action = listSumActions.get(i);
            System.out.println("type:" + action.getType() + " ;Timestamp:" + action.getTimestamp() + ";");
        }

        //...test 两个参数......
        System.out.println("\n" + "---------------我是分割线--------------------------");
        List<Action> listTypeActions = myActionHistory.getRecentActions("myClick", 20);
        System.out.println("listTypeActions.size(): " + listTypeActions.size() + "   | 获得特定type类别的前n项值：");
        for (int i = 0; i < listTypeActions.size(); i++) {
            Action action = listTypeActions.get(i);
            System.out.println("type:" + action.getType() + " ;Timestamp:" + action.getTimestamp() + ";");
        }


    }


}

/**
 * 表示一个用户行为，包含type，timestamp， info信息
 */
interface Action {
    public String getType();

    public long getTimestamp();

    public String getInfo();
}

/**
 * 表示一个用户的行为历史
 */
interface ActionHistory {
    public void addNewAction(Action action);

    public List<Action> getRecentActions(int n);

    public List<Action> getRecentActions(String type, int n);
}

class MyAciton implements Action, Comparable<MyAciton> {
    private String type;
    private long timeStamp;
    private String info;

    public MyAciton(String type, long timeStamp, String info) {
        super();
        this.type = type;
        this.timeStamp = timeStamp;
        this.info = info;
    }

    public String getType() {
        return type;

    }

    public long getTimestamp() {
        return timeStamp;

    }

    public String getInfo() {
        return info;

    }

    @Override
    public int compareTo(MyAciton o) {//升序排序
        return this.getTimestamp() > o.getTimestamp() ? -1 : (this.getTimestamp() < o.getTimestamp() ? 1 : 0);
    }
}

class UserActionHistory implements ActionHistory {

    private static Map<String, List<Action>> mapAcitonRecord = new HashMap<>();

    @Override
    public void addNewAction(Action action) {
        // TODO Auto-generated method stub
        if (mapAcitonRecord.containsKey(action.getType())) {
            mapAcitonRecord.get(action.getType()).add(action);
        } else {
            ArrayList<Action> arrayList = new ArrayList<Action>();
            arrayList.add(action);
            mapAcitonRecord.put(action.getType(), arrayList);
        }
    }

    @Override
    public List<Action> getRecentActions(int n) {
        // TODO Auto-generated method stub
        return getSumTopK(n);     // 全部类型的最近几条记录
    }

    @Override
    public List<Action> getRecentActions(String type, int n) {
        return getTypeTopK(type, n);   // 特定类型的最近几条记录
    }

    public Map<String, List<Action>> getMapRecord() {
        // TODO Auto-generated method stub
        return mapAcitonRecord;
    }

    /**
     * 获取全部类型的最近topK用户行为记录
     */
    public List<Action> getSumTopK(int n) {
        // 计数已经弹出第count个元素；保证增长的count==n
        int count = 0;
        Map<String, Integer> currIndexMap = new HashMap<>();
        ArrayList<Action> resultList = new ArrayList<>();

        // 初始化保存各个类型的最有各个元素的下标，到currIndexMap
        for (Entry<String, List<Action>> entry : mapAcitonRecord.entrySet()) {
            String type = entry.getKey();
            List<Action> queueList = entry.getValue();
            int index = queueList.size() - 1;
            currIndexMap.put(type, index);
        }

        int typeSize = currIndexMap.size();      // 总的类型type数量
        PriorityQueue<Action> priorityQueue = new PriorityQueue<>();    // 其实际上是一个大顶锥的实现
        for (Entry<String, List<Action>> entry : mapAcitonRecord.entrySet()) {
            String type = entry.getKey();
            List<Action> queueList = entry.getValue();
            // 将各个类型type的最后一个元素添加到 priorityQueue，实际一共typeSize个
            priorityQueue.offer(queueList.get(currIndexMap.get(type)));
        }

        while (!priorityQueue.isEmpty()) {
            Action maxAction = priorityQueue.poll();      // 弹出最大的元素:最新时间戳
            resultList.add(maxAction);
            count++;
            if (count == n) {                     // 计数增加到n时候，就停止循环
                break;
            }
            // 更新到下一个下标:并将下一个目标的元素添加到大顶堆中
            String type = maxAction.getType();
            int nextIndex = currIndexMap.get(type) - 1;
            // 单个队列中向前找的过程中，没有其他元素的值了:此时防止空指针出现，此时，该类型已经不存在了，直接将该type的指针记录清空
            if (nextIndex < 0) {
                currIndexMap.remove(type);
            }else {
                currIndexMap.put(type, nextIndex);
                priorityQueue.offer(mapAcitonRecord.get(type).get(nextIndex));
            }
            // 最终所有type的元素都弹出，此时currIndexMap为空，表示没有元素可以加入优先级队列了.此时直接弹出所有的元素。
            if (currIndexMap.size() == 0) {
                while (!priorityQueue.isEmpty()) {
                    Action maxActionTem = priorityQueue.poll();   // 弹出最大的元素:最新时间戳
                    resultList.add(maxActionTem);
                    count++;
                }
                return resultList;
            }
        }
        return resultList;
    }

    /**
     * 获得指定类型的最新n条 用户行为 记录
     */
    public List<Action> getTypeTopK(String type, int n) {
        ArrayList<Action> resultList = new ArrayList<>();
        if (mapAcitonRecord.containsKey(type)) {
            List<Action> list = mapAcitonRecord.get(type);
            int size = list.size();
            // 防止非法参数传入
            if (n < 0 || n > size) {
                return resultList;
            }
            for (int i = size - 1; i >= size - n; i--) {
                resultList.add(list.get(i));
            }
            return resultList;
        }
        return resultList;
    }


}

