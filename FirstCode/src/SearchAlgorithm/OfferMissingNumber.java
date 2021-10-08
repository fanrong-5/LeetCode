package SearchAlgorithm;
import java.util.*;
/**
 * @author fanrong
 * @create 2021/9/18 5:17 下午
 * 题目描述：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 *          在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
 * 输入: [0,1,3]
 * 输出: 2
 */
public class OfferMissingNumber {

    public static int missingNumber(int[] nums){
        int i =0,j=nums.length-1;
        while(i<=j){
            int m = (i+j)/2;
            if(nums[m]==m) i=m+1;
            else  j=m-1;
        }
        return i;
    }

    public static void main(String args[]){

        // 输入一行数据，以空格分隔，结束输入条件：回车
        ArrayList<Integer> input = new ArrayList() ;
        Scanner sc1 = new Scanner(System.in);
        String line = sc1.nextLine();
        Scanner sc2 = new Scanner(line);

        while(sc2.hasNextInt()){
            input.add(sc2.nextInt());
        }

        // 将输入信息转化为数组
        int[] nums = new int[input.size()];
        for(int i = 0;i< input.size();i++){
            nums[i] = input.get(i);
        }

        // 输出最终结果
        System.out.println(missingNumber(nums));
    }
}
