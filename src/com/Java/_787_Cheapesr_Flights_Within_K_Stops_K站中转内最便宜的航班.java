package src.com.Java;

import java.util.Arrays;

/*
有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
示例 1:
输入: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
输出: 200
解释: 
从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200
示例 2:
输入: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
输出: 500
解释: 
从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500
 */
public class _787_Cheapesr_Flights_Within_K_Stops_K站中转内最便宜的航班 {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            int[][] dp = new int[n][K + 2];
            // init
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], 1000000000);
            }
            dp[src][0] = 0;
            // dp
            for (int j = 1; j < K + 2; j++) {
                dp[src][j] = 0; // init
                for (int[] flight : flights) {
                    dp[flight[1]][j] = Math.min(dp[flight[1]][j], dp[flight[0]][j - 1] + flight[2]);
                }
            }

            return dp[dst][K + 1] == 1000000000 ? -1 : dp[dst][K + 1];
        }
    }

    class Solution2 {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            int[] prices = new int[n];
            Arrays.fill(prices, Integer.MAX_VALUE);
            prices[src] = 0;

            for (int i = 0; i <= K; i++) {
                int[] tmp = Arrays.copyOf(prices, n);
                for (int[] flight : flights) {
                    int from = flight[0], to = flight[1], price = flight[2];
                    if (prices[from] == Integer.MAX_VALUE)
                        continue;
                    tmp[to] = Math.min(prices[from] + price, tmp[to]);
                }
                prices = tmp;
            }
            return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
        }
    }
}
