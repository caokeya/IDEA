package src.com.Java;

public class _079_Word_Search_单词搜索 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int y = 0; y < board.length; y++) {
                for (int x = 0; x < board[y].length; x++) {
                    if (exist(board, y, x, w, 0))
                        return true;
                }
            }
            return false;
        }

        private boolean exist(char[][] board, int y, int x, char[] word, int i) {
            if (i == word.length)
                return true;
            if (y < 0 || x < 0 || y == board.length || x == board[y].length)
                return false;
            if (board[y][x] != word[i])
                return false;
            board[y][x] ^= 256;//将当前元素 XOR 256会得到将当前的元素遮盖起来(即得到一个非字母字符的表示)
            boolean exist = exist(board, y, x + 1, word, i + 1) || exist(board, y, x - 1, word, i + 1)
                    || exist(board, y + 1, x, word, i + 1) || exist(board, y - 1, x, word, i + 1);
            board[y][x] ^= 256;//在搜索过后，需要将被遮盖的元素重新恢复过来，从而不影响下一次的重新搜索，这时候只要再进行一次 XOR 256即可
            return exist;
        }
    }
}
