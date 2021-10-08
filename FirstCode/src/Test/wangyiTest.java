package Test;
import java.util.*;
/**
 * @author fanrong
 * @create 2021/9/18 7:11 下午
 * 题目描述：整除，判断一个整型数字的每一位能否被该数字整除
 * 输入：7300
 * 输出：0
 */
public class wangyiTest {

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

    // 计算10的n次方
    public static int calculate(int n){

        int result  = 1;
        while(n>1){
            result = result * 10 ;
            n--;
        }
        return result;
    }
    public static void main(String[] args) {

        // 输入
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int len = input.length();
        int num = Integer.parseInt(input);
        int[] nums = new int[len];  // 存储每一位
        int temp = 0;
        int tempNum = num;

        // 计算出该数字中的每一位
        while(temp<len){

            int divide = calculate(len-temp);
            nums[temp++] = tempNum / divide;
            tempNum = tempNum % divide;

        }

        System.out.println(Arrays.toString(nums));
        System.out.println(solution(num,nums));

    }
}
