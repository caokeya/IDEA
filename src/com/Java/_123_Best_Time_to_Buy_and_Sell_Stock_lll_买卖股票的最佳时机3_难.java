package com.Java;

//只能两次买卖
/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1:
输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 */
/*
121. Best Time to Buy and Sell Stock
122. Best Time to Buy and Sell Stock II
123. Best Time to Buy and Sell Stock III
188. Best Time to Buy and Sell Stock IV
309. Best Time to Buy and Sell Stock with Cooldown
714. Best Time to Buy and Sell Stock with Transaction Fee
 */
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
