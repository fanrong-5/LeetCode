package SearchAlgorithm;
import java.util.*;

/**
 * @author fanrong
 * @create 2021/9/18 3:12 下午
 * 题目：查找数组中任意一个重复的数字
 * 输入：[2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */

public class OfferFindRepeatNumber {

    public static int findRepeatNumber(int[] nums){
        int repeat = -1;

        // 新建HashSet
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            if(!numSet.add(num)){
                repeat = num;
                break;
            }
        }
        // 遍历数组
        return repeat;
    }

    public static void main(String args[]){
        // 输入一个数组，且不知道数组大小，以 逗号 分隔
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numStr = input.split(",");
        int[] nums = new int[numStr.length];

        for(int i =0;i<numStr.length;i++){
            nums[i] = Integer.parseInt(numStr[i]);  // 将字符串数组中的字符转化为INT
        }

        System.out.println(findRepeatNumber(nums));
    }

}
