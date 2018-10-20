package src.com.Java;

/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1:
输入: [2,4,1], k = 2
输出: 2
解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2:
输入: [3,2,6,5,0,3], k = 2
输出: 7
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
          随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
/*
121. Best Time to Buy and Sell Stock
122. Best Time to Buy and Sell Stock II
123. Best Time to Buy and Sell Stock III
188. Best Time to Buy and Sell Stock IV
309. Best Time to Buy and Sell Stock with Cooldown
714. Best Time to Buy and Sell Stock with Transaction Fee
 */
public class _188_Best_Time_to_Buy_and_Sell_Stock_IV_买卖股票的最佳时机4_难 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            //如果可操作次数超过k那么就有足够的次数来抓住所有的上升沿
            //即所有的上升沿加在一起就是最大profit
            if (k >= prices.length / 2)
                return quickSolve(prices);
            int[] sell = new int[k + 1];
            int[] buy = new int[k + 1];
            for (int i = 0; i < buy.length; i++)
                buy[i] = Integer.MIN_VALUE;
            for (int p : prices) {
                for (int i = k; i >= 1; i--) {
                    sell[i] = Math.max(sell[i], buy[i] + p);
                    buy[i] = Math.max(buy[i], sell[i - 1] - p);
                }
            }
            return sell[k];
        }

        //所有的上升沿都是利润
        private int quickSolve(int[] prices) {
            int len = prices.length, profit = 0;
            for (int i = 1; i < len; i++)
                // as long as there is a price gap, we gain a profit.
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            return profit;
        }
    }
}
