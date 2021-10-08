package DynamicProgramming;

/**
 * @author fanrong
 * @create 2021/9/18 6:47 下午
 * 题目描述：斐波那契数列
 */
public class OfferFib {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
