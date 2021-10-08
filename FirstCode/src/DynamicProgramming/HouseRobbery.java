package DynamicProgramming;
import java.util.*;

/**
 * @author fanrong
 * @create 2021/9/20 11:19 上午
 * 题目：给定一个代表每个房屋存放金额的非负整数数组，计算你不偷两间相邻的房屋 ，一夜之内能够偷窃到的最高金额。
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */

public class HouseRobbery {

    public static int rob(int[] nums){
        if(nums.length == 0 || nums ==null) return 0;
        if(nums.length == 1) return nums[0];

        int len = nums.length;
        int[] a = new int[len];  // a[i] ：表示 0-i 天、且第i天必偷nums[i]的 Max

        a[0] = nums[0];
        a[1] = Math.max(nums[0],nums[1]);
        int maxValue = Math.max(a[0],a[1]);

        for(int i =2;i<len;i++){
            a[i] = Math.max(a[i-1],a[i-2]+nums[i]);  // 前者最大值、当前最大值、新的最大值
            maxValue = Math.max(maxValue,a[i]);
        }

        return maxValue;
    }

    /**
     * 描述：将【字符串】—【字符串数组】-【整型数组】
     * @param str
     * @return
     */
    public static int[] strParser(String str){

        // 通过split方法，将【字符】转化为【字符串数组】
        String[] strArr = str.split(",");

        // 将【字符串数组】转化为【整型数组】
        int[] numArr = new int[strArr.length];
        for(int i =0;i< strArr.length;i++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        return numArr;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(strParser(input).length);
        System.out.println(rob(strParser(input)));

    }
}
