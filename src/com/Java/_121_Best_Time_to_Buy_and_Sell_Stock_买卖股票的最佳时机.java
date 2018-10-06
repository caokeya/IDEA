package src.com.Java;
//只能交易一次
/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
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
