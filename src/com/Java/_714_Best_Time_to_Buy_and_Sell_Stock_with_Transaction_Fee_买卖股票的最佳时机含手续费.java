package com.Java;
/*
给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。
示例 1:
输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:  
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
/*
121. Best Time to Buy and Sell Stock
122. Best Time to Buy and Sell Stock II
123. Best Time to Buy and Sell Stock III
188. Best Time to Buy and Sell Stock IV
309. Best Time to Buy and Sell Stock with Cooldown
714. Best Time to Buy and Sell Stock with Transaction Fee
 */
public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_买卖股票的最佳时机含手续费 {
    class Solution {
        // DP with constant space: O(n) time, O(1) space
        // For each day's stock, we can either buy it or sell it
        // If we sell, that means we bought before, hence sell = price + buy - fee
        // If we buy, that menas we sold before, hence buy = sell - price
        //O(N) time, O(1) space
        public int maxProfit(int[] prices, int fee) {
            int buy = -prices[0], sell = 0; // We must buy stock first, if all decresing then sell won't be updated, hence sell = 0
            for (int price : prices) {
                // Since we already buy it before for loop, we must sell it first then check buying situations
                sell = Math.max(sell, buy + price - fee);
                buy = Math.max(buy, sell - price); // no transiction fee when just buying
            }
            return sell; // You must ending up finishing a transction, hence we return sell (if all decresing, then sell = 0)
            // return Math.max(buy, sell) works too
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices, int fee) {
            if (prices.length == 0)
                return 0;
            int[] buy = new int[prices.length];
            int[] sell = new int[prices.length];
            buy[0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
            }
            return sell[prices.length - 1];
        }
    }
}
