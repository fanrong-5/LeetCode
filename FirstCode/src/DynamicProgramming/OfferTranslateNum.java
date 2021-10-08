package DynamicProgramming;
import java.util.*;

/**
 * @author fanrong
 * @create 2021/9/20 11:02 上午
 * 题目：将数字翻译为字符串的种树
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class OfferTranslateNum {

    public static int translateNum(int num) {

        String src = String.valueOf(num);   // 将【整型数字】转化为【字符串】
        int pre = 0, curr = 0, res = 1;  // pre相当于a[i-2] q相当于a[i-1]
        for (int i = 0; i < src.length(); ++i) {

            // 每次循环，更新三个变量的状态
            pre = curr;
            curr = res;
            res = 0;
            res += curr;   // 单独翻译的情况
            if (i == 0) {
                continue;
            }
            String preStr = src.substring(i - 1, i + 1);   // 截取
            if (preStr.compareTo("25") <= 0 && preStr.compareTo("10") >= 0) {
                res += pre;  // 组合翻译的情况
            }
        }
        return res;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(translateNum(num));

    }
}
