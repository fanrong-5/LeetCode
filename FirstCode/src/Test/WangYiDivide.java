package Test;
import java.util.*;
/**
 * @author didi
 * @create 2021/9/18 10:15 下午
 *  题目描述：整除，判断一个整型数字的每一位能否被该数字整除
 *  输入：7300
 *  输出：0
 */
public class WangYiDivide {

    /**
     * 描述：计算一共有几位数可以被该数字整除
     * @param num  输入的数字
     * @param nums 数组：存储数字的每一位
     * @return
     */

    public static int solution(int num,int[] nums){

        int result = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0){
                if(num%nums[i]==0){
                    result ++;
                }
            }
        }
        return result;
    }

    /**
     * 描述：将【字符串】—【字符串数组】-【整型数组】
     * @param str
     * @return
     */
    public static int[] strParser(String str){

        // 通过split方法，将【字符】转化为【字符串数组】
        String[] strArr = str.split("");

        // 将【字符串数组】转化为【整型数组】
        int[] numArr = new int[strArr.length];
        for(int i =0;i< strArr.length;i++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        return numArr;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();

        // 将字符串转化为数组
        int num = Integer.parseInt(inputStr);

        System.out.println(solution(num,strParser(inputStr)));

    }
}
