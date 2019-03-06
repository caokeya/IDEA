package src.com.Java;

import java.util.HashSet;
/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class _036_Valid_Sudoku_有效的数独 {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                HashSet<Character> rows = new HashSet<Character>();
                HashSet<Character> columns = new HashSet<Character>();
                HashSet<Character> cube = new HashSet<Character>();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.' && !rows.add(board[i][j]))
                        return false;
                    if (board[j][i] != '.' && !columns.add(board[j][i]))
                        return false;
                    int RowIndex = 3 * (i / 3);
                    int ColIndex = 3 * (i % 3);
                    if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'
                            && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                        return false;
                }
            }
            return true;
        }
    }
}
