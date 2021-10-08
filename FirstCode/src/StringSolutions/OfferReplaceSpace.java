package StringSolutions;
import java.util.*;
/**
 * @author fanrong
 * @create 2021/9/17 3:54 下午
 * 题目：替换空格
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class OfferReplaceSpace {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();  // 输入字符串
        int len = str.length();
        char[] newStr = new char[len*3];

        int size = 0;   // 新数组的索引
        // 遍历字符串
        for(int i = 0;i<len;i++){
            char c = str.charAt(i);
            if(c == ' '){
                newStr[size++] = '%';
                newStr[size++] = '3';
                newStr[size++] = '0';
            }else{
                newStr[size++] = c;
            }
        }

        // 输出新字符串

        String resultStr = new String(newStr,0,size);
        System.out.println(resultStr);
    }

}
