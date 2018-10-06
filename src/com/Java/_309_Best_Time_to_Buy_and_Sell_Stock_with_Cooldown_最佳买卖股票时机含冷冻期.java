package src.com.Java;

/*
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:
输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_最佳买卖股票时机含冷冻期 {
    class Solution {
        /* 最优化，求最大
                         设 sell[i] 为“第 i 天结束时为卖出状态（恰好第 i 天卖出，或之前卖出后未买入）的最大利润”
           buy[i] 为“第 i天结束时为买入状态的最大利润”，cool[i] 为“第 i 天结束时为冷却状态的最大利润”，则：
           1. sell[i] = max{sell[i - 1], buy[i - 1] + p[i]}
           2. buy[i] = max{buy[i - 1], cool[i - 1] - p[i]}
           3. cool[i] = max{cool[i - 1], sell[i - 1]}
         */
        public int maxProfit(int[] prices) {
            int[] p = prices;
            if (p == null || p.length < 2) {
                return 0;
            }

            int n = p.length;
            int[] sell = new int[n];
            int[] buy = new int[n];
            int[] cool = new int[n];
            sell[0] = 0;
            buy[0] = -p[0];
            cool[0] = 0;
            for (int i = 1; i < n; i++) {
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + p[i]);
                buy[i] = Math.max(buy[i - 1], cool[i - 1] - p[i]);
                cool[i] = Math.max(cool[i - 1], sell[i - 1]);
            }
            return Math.max(sell[n - 1], cool[n - 1]);
        }
    }
}
