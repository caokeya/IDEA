package src.com.Java;

import java.util.Arrays;

/*
一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
    0 表示这个格子是空的，所以你可以穿过它。
    1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
    -1 表示这个格子里有荆棘，挡着你的路。
你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
    从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
    当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
    当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
    如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
示例 1:
输入: grid =
[[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]]
输出: 5
解释： 
玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
 */
public class _741_Cherry_Pickup_摘樱桃_难 {
    class Solution {
        public int cherryPickup(int[][] grid) {
            int N = grid.length, M = (N << 1) - 1;
            int[][] dp = new int[N][N];
            dp[0][0] = grid[0][0];

            for (int n = 1; n < M; n++) {
                for (int i = N - 1; i >= 0; i--) {
                    for (int p = N - 1; p >= 0; p--) {
                        int j = n - i, q = n - p;

                        if (j < 0 || j >= N || q < 0 || q >= N || grid[i][j] < 0 || grid[p][q] < 0) {
                            dp[i][p] = -1;
                            continue;
                        }

                        if (i > 0)
                            dp[i][p] = Math.max(dp[i][p], dp[i - 1][p]);
                        if (p > 0)
                            dp[i][p] = Math.max(dp[i][p], dp[i][p - 1]);
                        if (i > 0 && p > 0)
                            dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1]);
                        if (dp[i][p] >= 0)
                            dp[i][p] += grid[i][j] + (i != p ? grid[p][q] : 0);
                    }
                }
            }
            return Math.max(dp[N - 1][N - 1], 0);
        }
    }

    class Solution2 {

        int[][][] memo; // 3D-DP
        int[][] grid;
        int N;

        public int cherryPickup(int[][] grid) {
            // If it was one-way, solution would be 2D-DP.
            // The challenge is the return trip can't be resolved standalone, moreover,
            // cherrys can not be picked twice.
            // Translates the problem to 2 persons walking down the matrix concurrently in 2
            // paths. Cherrys can not be picked repeatedly.
            // Since the 2 persons move in sync, if one is on (r1, c1), the second is on
            // (r2, r1+c1-r2).
            // r1, c1, r2 => 3D-DP
            // 难点在于一人走两遍时第一段trip的最优解并不保证是全局roundtrip的最优解, 这也是DP的特性.
            // 把一人走两遍转换成两人同时走一遍, 增加一个维度
            // 采cherry时候两人不能在同一个格子里
            // Tail Recursion + 3D-DP
            this.grid = grid;
            N = grid.length; // row count
            memo = new int[N][N][N]; // 3D-DP matrix
            for (int[][] layer : memo)
                for (int[] row : layer)
                    Arrays.fill(row, Integer.MIN_VALUE); // initial value
            return Math.max(0, dp(0, 0, 0)); // recursion
        }

        public int dp(int r1, int c1, int c2) { // recursion
            // 3D-DP + head recursion
            int r2 = r1 + c1 - c2; // 两人同步, 如果取memo[r][c][person]就不能表达同步
            if (N == r1 || N == r2 || N == c1 || N == c2 || grid[r1][c1] == -1 || grid[r2][c2] == -1) {// out of border,
                // or meet thorn
                return -999999; // least optimized
            } else if (r1 == N - 1 && c1 == N - 1) { // exit, bottom right corner
                return grid[r1][c1];
            } else if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
                return memo[r1][c1][c2]; // visited memorization
            } else { // incremental case => recursion
                int ans = grid[r1][c1]; // pick cherry
                if (c1 != c2)
                    ans += grid[r2][c2]; // avoid repeated pick
                ans += Math.max(Math.max(dp(r1, c1 + 1, c2 + 1), dp(r1 + 1, c1, c2 + 1)), // transition function => 4
                        // cases
                        Math.max(dp(r1, c1 + 1, c2), dp(r1 + 1, c1, c2))); // head recursion
                // 注意这里并不是用memo(r1, c1+1, c2+1)..., 而是用recursion
                memo[r1][c1][c2] = ans;
                return ans;
            }
        }
    }
}
