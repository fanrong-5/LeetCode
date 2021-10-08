package Test;
import java.util.*;

public class Test {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        String[] str = inputStr.split("");
        int[] nums = new int[str.length];
        for(int i=0;i< str.length;i++){
            nums[i] = Integer.parseInt(str[i]);
        }

        System.out.println(Arrays.toString(nums));

    }
}

/**
 * 表示一个用户行为，包含type，timestamp， info信息
 *//*

interface Action {
    public String getType();       // 获得用户类型
    public long getTimestamp();     // 获得用户登陆时间
    public String getInfo();        // 获得用户信息
}

/**
 * 表示一个用户的行为历史
 *//*

interface ActionHistory ｛
public void addNewAction(Action action);       // 添加最新的用户行为
public List<Action> getRecentActions(int n);   //  获得用户最近的n条行为信息
public List<Action> getRecentActions(String type, int n); // 根据行为类型拿到最近n条
        }

要求：要求实现ActionHistory下的方法  你发我ActionHistroy的实现类就好
*/

