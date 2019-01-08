package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。
连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
示例:
输入: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
输出: ["catsdogcats","dogcatsdog","ratcatdogcat"]
解释: "catsdogcats"由"cats", "dog" 和 "cats"组成; 
     "dogcatsdog"由"dog", "cats"和"dog"组成; 
     "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
 */
public class _472_Concatenated_Words_连接词_难 {
    class Solution {
        private TrieNode root;

        private class TrieNode {
            TrieNode[] next;
            boolean isWord;

            public TrieNode() {
                next = new TrieNode[26];
            }
        }

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> res = new ArrayList<String>();
            if (words == null || words.length <= 2) return res;
            root = new TrieNode();
            for (String word : words) {
                add(word, root);
            }
            for (String word : words) {
                if (testWord(word.toCharArray(), 0, 0))
                    res.add(word);
            }
            return res;
        }

        private void add(String word, TrieNode root) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //注意这里因为cur的next是一个类数组，不像int[]这样primitive型数组(int[]这样的数组初始化后直接全为初始化0),
                //所以cur的next初始化后内部element都为null.
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new TrieNode();
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }

        private boolean testWord(char[] word, int start, int count) {
            if (start == word.length && count >= 2) return true;
            TrieNode cur = root; //when found a word, restart the TrieNode from the root...
            for (int i = start; i < word.length; i++) {
                cur = cur.next[word[i] - 'a'];
                //这个if的位置很关键
                if (cur == null) return false; //the current segment is not in the list...
                    //找到一个word，则剩下的部分也必须为一个subword
                else if (cur.isWord && testWord(word, i + 1, count + 1))
                    return true;
                else continue;
            }
            return false;
        }
    }

    class Solution2 {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> ret = new ArrayList<>();
            Set<String> set = new HashSet<>();
            for (String word : words) {
                set.add(word);
            }
            for (String word : words) {
                if (isConcatenated(set, word))
                    ret.add(word);
            }
            return ret;
        }

        private boolean isConcatenated(Set<String> set, String s) {
            for (int i = 1; i < s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    String rightStr = s.substring(i);
                    if (set.contains(rightStr) || isConcatenated(set, rightStr))
                        return true;
                }
            }
            return false;
        }
    }
}
