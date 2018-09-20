package src.com.Java;
//只能交易一次
public class _121_Best_Time_to_Buy_and_Sell_Stock_买卖股票的最佳时机 {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxCur = 0, maxSoFar = 0;
            for (int i = 1; i < prices.length; i++) {
                maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
                maxSoFar = Math.max(maxCur, maxSoFar);
            }
            return maxSoFar;
        }
    }
}
