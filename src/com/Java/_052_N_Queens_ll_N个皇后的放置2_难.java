package com.Java;
/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回 n 皇后不同的解决方案的数量。
示例:
输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class _052_N_Queens_ll_N个皇后的放置2_难 {
    public class Solution {
        int count = 0;

        public int totalNQueens(int n) {
            boolean[] cols = new boolean[n]; // columns |
            boolean[] d1 = new boolean[2 * n]; // diagonals \
            boolean[] d2 = new boolean[2 * n]; // diagonals /
            backtracking(0, cols, d1, d2, n);
            return count;
        }

        public void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
            if (row == n)
                count++;

            for (int col = 0; col < n; col++) {
                int id1 = col - row + n;
                int id2 = col + row;
                if (cols[col] || d1[id1] || d2[id2])
                    continue;

                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                backtracking(row + 1, cols, d1, d2, n);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}
