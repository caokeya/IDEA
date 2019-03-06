package src.com.Java;

/*
帮派里有 G 名成员，他们可能犯下各种各样的罪行。
第 i 种犯罪会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。
让我们把这些犯罪的任何子集称为盈利计划，该计划至少产生 P 的利润。
有多少种方案可以选择？因为答案很大，所以返回它模 10^9 + 7 的值。
示例 1：
输入：G = 5, P = 3, group = [2,2], profit = [2,3]
输出：2
解释： 
至少产生 3 的利润，该帮派可以犯下罪 0 和罪 1 ，或仅犯下罪 1 。
总的来说，有两种方案。
示例 2:
输入：G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
输出：7
解释：
至少产生 5 的利润，只要他们犯其中一种罪就行，所以该帮派可以犯下任何罪行 。
有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 */
public class _879_Profitable_Schemes_盈利计划_难 {
    class Solution {
        public int profitableSchemes(int G, int P, int[] group, int[] profit) {
            // 求解的个数, must be DP.
            // 本题还是个Knapsack, 但是target变成了2个, 而且target变成了上界和下界, 不是完全固定. 解法还是Knapsack.
            // cost G and profit P成了2个targets, 而且G是上界, P是下界.
            // DP transition function,
            // dp[i + p][j + g] += dp[i][j] if i + p < P
            // dp[P][j + g] += dp[i][j] if i + p >= P (这样统计方便, P只要超过下界都算是P)
            int[][] dp = new int[P + 1][G + 1];     // offset = 1, profit and cost
            dp[0][0] = 1;                           
            int res = 0, mod = (int)1e9 + 7;
            for (int k = 0; k < group.length; k++) {    // profit + cost ~ incremental resource (not repeatable)
                int g = group[k], p = profit[k];        // resource不能重用 => outer loop 
                for (int i = P; i >= 0; i--)            // decremental target - profit, max out at P (>=P is fine)
                    for (int j = G - g; j >= 0; j--)    // decremental target - cost, to keep max j at G (must <=G)
                        dp[Math.min(i + p, P)][j + g] = (dp[Math.min(i + p, P)][j + g] + dp[i][j]) % mod;
                        // 第一次加入的是dp[p][g] = dp[0][0] = 1
            }
            for (int x : dp[P])     // profit >= p and cost <= G
                res = (res + x) % mod;      // 叠加cost下界
            return res;
        }
    }
    class Solution2 {
        public int profitableSchemes(int G, int P, int[] group, int[] profit) {
            int[][] dp = new int[G + 1][P + 1];
            int mod = (int) Math.pow(10, 9) + 7;
            dp[0][0] = 1;// 赚钱为0,0个人只有一种结果
            int sum = 0;
            for (int k = 0; k < group.length; k++) {
                for (int i = G; i >= group[k]; i--) {
                    for (int j = P; j >= 0; j--) {
                        dp[i][j] = (dp[i][j] + dp[i - group[k]][Math.max(0, j - profit[k])]) % mod;
                    }
                }
            }
            for (int i = 0; i < dp.length; i++) {
                sum = (sum + dp[i][P]) % mod;
            }
            return sum;
        }
    }

}
