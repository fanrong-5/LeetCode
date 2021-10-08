package SearchAlgorithm;
import java.util.*;
/**
 * @author fanrong
 * @create 2021/9/18 3:43 下午
 * 题目描述：统计一个数字在排序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class OfferFindNumFrequency_I {

    public static int findNumFrequency(int[] nums,int target){
        int freq = 0;
        int len = nums.length;

        for(int i =0;i<len;i++){

            if(nums[i]==target){
                freq ++;
            }
            if(nums[i]>target) break;

        }

        return freq;
    }

    public static void main(String args[]){

        // 输入两行数据:以逗号 分隔的数组 和 目标值
        Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();
         int target = sc.nextInt();

         String[] numStr = input.split(",");
         int[] nums = new int[numStr.length];

         for(int i =0;i<numStr.length;i++){
             nums[i] = Integer.parseInt(numStr[i]);
         }

         System.out.println(findNumFrequency(nums,target));

    }

}
