package src.com.Java;

import java.util.Arrays;

/*
已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。 
现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。 
如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
求移动结束后，“马” 仍留在棋盘上的概率。
示例：
输入: 3, 2, 0, 0
输出: 0.0625
解释: 
输入的数据依次为 N, K, r, c
第 1 步时，有且只有 2 种走法令 “马” 可以留在棋盘上（跳到（1,2）或（2,1））。
对于以上的两种情况，各自在第2步均有且只有2种走法令 “马” 仍然留在棋盘上。
所以 “马” 在结束后仍在棋盘上的概率为 0.0625。
 */
public class _688_Knight_Probability_in_Chessboard_马在棋盘上的概率 {
    class Solution {
        int[][] moves = { { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };

        public double knightProbability(int N, int K, int r, int c) {
            int len = N;
            double dp0[][] = new double[len][len];
            for (double[] row : dp0)
                Arrays.fill(row, 1);
            for (int l = 0; l < K; l++) {
                double[][] dp1 = new double[len][len];
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        for (int[] move : moves) {
                            int row = i + move[0];
                            int col = j + move[1];
                            if (isLegal(row, col, len))
                                dp1[i][j] += dp0[row][col];
                        }
                    }
                }
                dp0 = dp1;
            }
            return dp0[r][c] / Math.pow(8, K);
        }

        private boolean isLegal(int r, int c, int len) {
            return r >= 0 && r < len && c >= 0 && c < len;
        }
    }
}
