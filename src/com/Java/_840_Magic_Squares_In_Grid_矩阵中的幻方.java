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
            int total = 0;
            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid[0].length; j++)
                    if (isMagic(grid, i, j))
                        total++;
            return total;
        }

        boolean isMagic(int[][] grid, int i, int j) {
            if (i + 2 >= grid.length || j + 2 >= grid[i].length)
                return false;
            Set<Integer> s = new HashSet<>();
            for (int x = 0; x < 3; x++)
                for (int y = 0; y < 3; y++)
                    if (!s.add(grid[i + x][j + y]) || grid[i + x][j + y] <= 0 || grid[i + x][j + y] > 9)
                        return false;

            int[] l = { grid[i][j] + grid[i + 1][j] + grid[i + 2][j],
                        grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1],
                        grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] };
            int[] r = { grid[i][j] + grid[i][j + 1] + grid[i][j + 2],
                        grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2],
                        grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] };
            int d1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
            int d2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
            return d1 == d2 && d2 == l[0] && l[0] == l[1] && l[1] == l[2] && l[2] == r[0] && r[0] == r[1]
                    && r[1] == r[2];
        }
    }
}
