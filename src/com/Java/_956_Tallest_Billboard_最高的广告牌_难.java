package src.com.Java;

/*
你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。
你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。
返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。
示例 1：
输入：[1,2,3,6]
输出：6
解释：我们有两个不相交的子集 {1,2,3} 和 {6}，它们具有相同的和 sum = 6。
示例 2：
输入：[1,2,3,4,5,6]
输出：10
解释：我们有两个不相交的子集 {2,3,5} 和 {4,6}，它们具有相同的和 sum = 10。
示例 3：
输入：[1,2]
输出：0
解释：没法安装广告牌，所以返回 0。
 */
public class _956_Tallest_Billboard_最高的广告牌_难 {
    class Solution {
        public int tallestBillboard(int[] rods) {
            int[] dp = new int[5001];
            for (int i = 1; i < 5001; i++)
                dp[i] = -10001;
            for (int rod : rods) {
                int[] cur = dp.clone();
                for (int i = 0; i + rod < 5001; i++) {
                    dp[i + rod] = Math.max(dp[i + rod], cur[i]);
                    dp[Math.abs(i - rod)] = Math.max(dp[Math.abs(i - rod)], cur[i] + Math.min(rod, i));
                }
            }
            return dp[0];
        }
    }

    class Solution2 {
        public int tallestBillboard(int[] rods) {
            int[][] memo = new int[rods.length + 1][5001];
            for (int i = 0; i < rods.length + 1; i++) {
                for (int j = 0; j < 5001; j++) {
                    memo[i][j] = -10000;
                }
            }
            memo[0][0] = 0;
            int res = dfs(rods.length, 0, rods, memo);
            return res;
        }

        private int dfs(int i, int diff, int[] rods, int[][] memo) {
            if (i < 0 || diff < 0 || diff > 5000) {
                return -10000;
            }

            if (i == 0 || memo[i][diff] != -10000) {
                return memo[i][diff];
            }

            int res = memo[i][diff];
            // add nothing
            res = Math.max(res, dfs(i - 1, diff, rods, memo));

            // add to the longer one
            res = Math.max(res, dfs(i - 1, diff - rods[i - 1], rods, memo));

            // add to the shorter one
            res = Math.max(res, 
                    Math.max(dfs(i - 1, diff + rods[i - 1], rods, memo) + rods[i - 1],
                             dfs(i - 1, rods[i - 1] - diff, rods, memo) + rods[i - 1] - diff));

            memo[i][diff] = res;
            return res;
        }

    }
}
