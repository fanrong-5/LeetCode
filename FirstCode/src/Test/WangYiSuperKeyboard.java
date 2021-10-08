package Test;
import java.util.*;
/**
 * @author didi
 * @create 2021/9/18 8:15 下午
 */
public class WangYiSuperKeyboard {

    public static int superKeyboard(char[] keys,int m){
        int result = 0;
        int n = 0;
        char key1 = keys[0];
        for(int i=0;i<keys.length;i++){
            if(keys[i]==key1){
                n ++;
            }
        }
        if(n == keys.length){
            result = n;
        }

        return result;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        int len = inputStr.length();
        int inputNum = sc.nextInt();

        char[] str = new char[len];

        for(int i=0;i<len;i++){
            str[i] = inputStr.charAt(i);
        }
        System.out.println(superKeyboard(str,inputNum));


    }
}
