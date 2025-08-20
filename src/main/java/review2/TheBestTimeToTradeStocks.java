package review2;

/**
 * 买卖股票的最佳时机
 */
public class TheBestTimeToTradeStocks {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else if (prices[i] > minPrice) {
                ans = Math.max(ans, prices[i] - minPrice);
            }
        }
        return Math.max(ans, 0);
    }
}
