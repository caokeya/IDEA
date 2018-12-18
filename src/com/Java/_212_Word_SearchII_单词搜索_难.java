package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 同一个单元格内的字母在一个单词中不允许被重复使用。
 示例:
 输入:
 words = ["oath","pea","eat","rain"] and board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 输出: ["eat","oath"]
*/
public class _212_Word_SearchII_单词搜索_难 {
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            TrieNode root = new TrieNode();
            List<String> res = new ArrayList<>();
            for (String s : words) {
                buildTrie(root, s);
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, root, i, j, res);
                }
            }
            return res;
        }

        private void dfs(char[][] board, TrieNode root, int i, int j, List<String> res) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || root.children[board[i][j] - 'a'] == null) {
                return;
            }
            root = root.children[board[i][j] - 'a'];
            char c = board[i][j];
            board[i][j] = '#';
            if (root.word != null) {
                res.add(root.word);
                root.word = null;
            }
            dfs(board, root, i - 1, j, res);
            dfs(board, root, i + 1, j, res);
            dfs(board, root, i, j - 1, res);
            dfs(board, root, i, j + 1, res);
            board[i][j] = c;
        }

        private void buildTrie(TrieNode root, String s) {
            char[] ch = s.toCharArray();
            for (char c : ch) {
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new TrieNode();
                }
                root = root.children[c - 'a'];
            }
            root.word = s;
        }

        class TrieNode {
            String word;
            TrieNode[] children;

            public TrieNode() {
                this.children = new TrieNode[26];
            }
        }
    }
}
