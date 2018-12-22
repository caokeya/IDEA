package src.com.Java;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
 */
public class _079_Word_Search_单词搜索 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        boolean result = search(board, j, i, word.toCharArray(), 0);
                        if (result)
                            return true;
                    }
                }
            }
            return false;
        }

        private boolean search(char[][] board, int x, int y, char[] word, int position) {
            if (word.length == position)
                return true;
            if ((x < 0) || (x > board[0].length - 1) ||
                    (y < 0) || (y > board.length - 1) ||
                    (board[y][x] != word[position])
            )
                return false;
            char c = board[y][x];
            board[y][x] = '*';
            boolean result =
                    search(board, x - 1, y, word, position + 1) ||
                            search(board, x + 1, y, word, position + 1) ||
                            search(board, x, y + 1, word, position + 1) ||
                            search(board, x, y - 1, word, position + 1);
            board[y][x] = c;
            return result;
        }
    }
}
