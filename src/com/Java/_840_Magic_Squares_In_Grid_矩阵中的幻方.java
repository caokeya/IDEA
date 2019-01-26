package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
示例 1:
输入: [[4,3,8,4],
      [9,5,1,9],
      [2,7,6,2]]
输出: 1
解释: 
下面的子矩阵是一个 3 x 3 的幻方：
438
951
276
而这一个不是：
384
519
762
总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 */
public class _840_Magic_Squares_In_Grid_矩阵中的幻方 {
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int R = grid.length, C = grid[0].length;
            int ans = 0;
            for (int r = 0; r < R - 2; ++r)
                for (int c = 0; c < C - 2; ++c) {
                    if (grid[r + 1][c + 1] != 5) continue;  // optional skip
                    if (magic(grid[r][c], grid[r][c + 1], grid[r][c + 2],
                              grid[r + 1][c], grid[r + 1][c + 1], grid[r + 1][c + 2],
                              grid[r + 2][c], grid[r + 2][c + 1], grid[r + 2][c + 2]))
                        ans++;
                }
            return ans;
        }

        public boolean magic(int... val) {
            int[] count = new int[16];
            for (int v : val)
                count[v]++;
            for (int v = 1; v <= 9; ++v)
                if (count[v] != 1)
                    return false;
            return (val[0] + val[1] + val[2] == 15 &&
                    val[3] + val[4] + val[5] == 15 &&
                    val[6] + val[7] + val[8] == 15 &&
                    val[0] + val[3] + val[6] == 15 &&
                    val[1] + val[4] + val[7] == 15 &&
                    val[2] + val[5] + val[8] == 15 &&
                    val[0] + val[4] + val[8] == 15 &&
                    val[2] + val[4] + val[6] == 15);
        }
    }
}
