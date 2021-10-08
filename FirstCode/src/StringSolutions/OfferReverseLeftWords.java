package StringSolutions;
import java.util.*;
/**
 * @author fanrong
 * @create 2021/9/17 4:45 下午
 * 题目：左旋转字符串
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 */
public class OfferReverseLeftWords {
    public  static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 输入 k

        // 换行输入字符串，以"end"结尾
        String str = "";
        while(true){
            if("end".equals(sc.nextLine())){
                break;
            }
            str = sc.nextLine();  // 输入字符串

        }

        String newStr = str.substring(n,str.length()) + str.substring(0,n) ;
        System.out.println(newStr);
    }
}
