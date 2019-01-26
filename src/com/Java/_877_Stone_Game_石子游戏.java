package src.com.Java;

import java.util.Arrays;

/*
亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
示例：
输入：[5,3,4,5]
输出：true
解释：
亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 */
public class _877_Stone_Game_石子游戏 {
    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] dp = new int[n][n];
            // dp[i][j]的意思是你能得到的最大数量的石头比对手在i`j中更多
            for (int i = 0; i < n; i++)
                dp[i][i] = piles[i];
            for (int d = 1; d < n; d++)
                for (int i = 0; i < n - d; i++)
                    /*
                     * If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
                     * If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
                     * j = i + d
                     */
                    dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
            return dp[0][n - 1] > 0;

        }
    }

    class Solution2 {
        public boolean stoneGame(int[] p) {
            int[] dp = Arrays.copyOf(p, p.length);
            for (int d = 1; d < p.length; d++)
                for (int i = 0; i < p.length - d; i++)
                    dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
            return dp[0] > 0;
        }
    }
}
