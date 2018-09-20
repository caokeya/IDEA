package src.com.Java;
//多次买卖
public class _122_Best_Time_to_Buy_and_Sell_Stock_ll_买卖股票的最佳时机2 {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxprofit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    maxprofit += prices[i] - prices[i - 1];
            }
            return maxprofit;
        }
    }
}
