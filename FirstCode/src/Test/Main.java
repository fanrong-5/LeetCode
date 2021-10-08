package Test;
import java.util.*;

/**
 * @author didi
 * @create 2021/10/8 1:23 下午
 */
public class Main {
    /*public static int minRoomNum(int[][] nums){
        int len = nums.length;

        if(nums ==null || len == 0 ) return 0;
        int[] start = new int[len];
        int[] end = new int[len];
        for(int i=0;i<len;i++){
            start[i] = nums[i][0];

            end[i] = nums[i][1];
        }


        // 排序
        Arrays.sort(start);
        Arrays.sort(end);
        PriorityQueue<Integer> queue = new PriorityQueue<>(len);
        queue.add(end[0]);

        // 计算
        for(int i=1;i<len;i++){
            if(start[i]<queue.peek()) queue.add(end[i]);
            queue.poll();

        }

        return queue.size() +1;
    }
    public static void main(String args[]){

        // 输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[3][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        // 输出
        System.out.println((nums.length));

        System.out.println(minRoomNum(nums));


    }*/

    public static int rain(int[] nums){
        int len = nums.length;

        if(len == 0) return 0;
        int res = 0;
        int low = 0;
        int high = len - 1;

        // 左边

        int[] lowRes = new int[len];
        lowRes[low] = nums[low];
        for(int i =1;i<len;i++){
            lowRes[i] = Math.max(lowRes[i-1],nums[i]);
        }

        // 右边
        int[] highRes = new int[len];
        highRes[high] = nums[high];
        for(int j=high-1;j>=0;j--){
            highRes[j] = Math.max(highRes[j+1],nums[j]);
        }

        // 结果

        for(int r =0;r<len;r++){

            int temp = Math.min(lowRes[r],highRes[r]);
            res += temp - nums[r];
        }

        return res;

    }

    public static int[] strParser(String str){
        String[] strArr = str.split(",");

        int[] numArr = new int[strArr.length];
        for(int i=0;i<strArr.length;i++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        return numArr;
    }

    public static void main(String args[]){

        // 输入
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = input.length();

        // 去除中括号
         String newInput = input.substring(1,len-1);

        // 获得数组 并进行计算

        System.out.println(rain(strParser(newInput)));


    }
}
