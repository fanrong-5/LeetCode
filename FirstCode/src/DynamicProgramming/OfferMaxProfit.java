package DynamicProgramming;

/**
 * @author didi
 * @create 2021/9/18 6:49 下午
 * 题目描述：股票的最大利润
 */
public class OfferMaxProfit {
    public int maxProfit(int[] prices) {

        if(prices.length == 0) return 0;

        int maxp = 0;
        int min = prices[0];
        int index = 0;

        for(int i = 0;i<prices.length;i++){
            if(prices[i]<min) min = prices[i];
            if(prices[i] - min > maxp) maxp = prices[i] - min;
        }

        return maxp;
    }
}
