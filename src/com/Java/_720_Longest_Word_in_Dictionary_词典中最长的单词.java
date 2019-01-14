package src.com.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
若其中有多个可行的答案，则返回答案中字典序最小的单词。
若无答案，则返回空字符串。
示例 1:
输入: 
words = ["w","wo","wor","worl", "world"]
输出: "world"
解释: 
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
示例 2:
输入: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出: "apple"
解释: 
"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 */
public class _720_Longest_Word_in_Dictionary_词典中最长的单词 {
    /*
    按字母顺序排列单词，因此短单词总是排在长单词之前; 沿着排序列表，填充可以构建的单词; 一个单词的任何前缀都必须在这个单词之前。
    */
    class Solution {
        public String longestWord(String[] words) {
            String ans = "";
            Set<String> wordset = new HashSet<String>();
            for (String word : words)
                wordset.add(word);
            for (String word : words) {
                if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                    boolean good = true;
                    for (int i = 1; i < word.length(); i++) {
                        if (!wordset.contains(word.substring(0, i))) {
                            good = false;
                            break;
                        }
                    }
                    if (good)
                        ans = word;
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public String longestWord(String[] words) {
            TrieNode root = new TrieNode();
            root.word = "-";
            for (String word : words)
                root.insert(word);
            return dfs(root, "");
        }

        String dfs(TrieNode node, String accum) {
            if (node == null || node.word.length() == 0)
                return accum;
            String res = "";
            if (!node.word.equals("-"))
                accum = node.word;
            for (TrieNode child : node.links) {
                String curRes = dfs(child, accum);
                if (curRes.length() > res.length() || (curRes.length() == res.length() && curRes.compareTo(res) < 0))
                    res = curRes;
            }
            return res;
        }

        /* Hand write this class every time you need to so you can remember well */
        class TrieNode {
            String word = "";
            TrieNode[] links = new TrieNode[26];

            void insert(String s) {
                char[] chs = s.toCharArray();
                TrieNode curNode = this;
                for (int i = 0; i < chs.length; i++) {
                    int index = chs[i] - 'a';
                    if (curNode.links[index] == null)
                        curNode.links[index] = new TrieNode();
                    curNode = curNode.links[index];
                }
                curNode.word = s;
            }
        }
    }
}
