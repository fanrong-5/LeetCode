package DynamicProgramming;

/**
 * @author fanrong
 * @create 2021/9/18 6:45 下午
 * 题目描述：青蛙跳台阶
 */
public class OfferNumWays {
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;

            // 注意：下面两行语句不可交换 顺序变了 逻辑就不对了
            a = b;
            b = sum;
        }
        return a;
    }
}
