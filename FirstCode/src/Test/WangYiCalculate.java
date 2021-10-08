package Test;
import java.util.*;
/**
 * @author didi
 * @create 2021/9/18 8:29 下午
 * 设计模式中，适配器模式和装饰器模式有什么区别
 */
public class WangYiCalculate {

    public static int calculate(int num){
        int result = 0;
        if(num == 1 || num == 0)  result = num;
        if(num%2==0){
            result =2;
        }
        return result;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(calculate(num));
    }
}
