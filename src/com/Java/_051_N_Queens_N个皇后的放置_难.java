package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例:
输入: 4
输出: [
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
public class _051_N_Queens_N个皇后的放置_难 {
    public class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    board[i][j] = '.';
            List<List<String>> res = new ArrayList<List<String>>();
            dfs(board, 0, res);
            return res;
        }

        private void dfs(char[][] board, int colIndex, List<List<String>> res) {
            if (colIndex == board.length) {
                res.add(construct(board));
                return;
            }

            for (int i = 0; i < board.length; i++) {
                if (validate(board, i, colIndex)) {
                    board[i][colIndex] = 'Q';
                    dfs(board, colIndex + 1, res);
                    board[i][colIndex] = '.';
                }
            }
        }

        private boolean validate(char[][] board, int x, int y) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                        return false;
                }
            }

            return true;
        }

        private List<String> construct(char[][] board) {
            List<String> res = new LinkedList<String>();
            for (int i = 0; i < board.length; i++) {
                String s = new String(board[i]);
                res.add(s);
            }
            return res;
        }
    }
}
