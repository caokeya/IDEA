package src.com.Java;

//只能两次买卖
public class _123_Best_Time_to_Buy_and_Sell_Stock_lll_买卖股票的最佳时机3_难 {
    class Solution {
        public int maxProfit(int[] prices) {
            int buy0 = Integer.MIN_VALUE, buy1 = Integer.MIN_VALUE, sell0 = 0, sell1 = 0;
            for (int i = 0; i < prices.length; i++) {
                buy0 = Math.max(buy0, -prices[i]);          // The maximum if we've just buy 1st stock so far.
                sell0 = Math.max(sell0, buy0 + prices[i]);  // The maximum if we've just sold 1nd stock so far.
                
                buy1 = Math.max(buy1, sell0 - prices[i]);   // The maximum if we've just buy 2nd stock so far.
                sell1 = Math.max(sell1, buy1 + prices[i]);  // The maximum if we've just sold 2nd stock so far.

            }
            return Math.max(sell1, sell0);
        }
    }
}
