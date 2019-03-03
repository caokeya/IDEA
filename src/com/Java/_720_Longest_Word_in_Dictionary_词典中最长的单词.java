package com.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
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
     * 按字母顺序排列单词，因此短单词总是排在长单词之前; 沿着排序列表，填充可以构建的单词; 一个单词的任何前缀都必须在这个单词之前。
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
            if (words == null || words.length == 0)
                return "";
            Trie head = new Trie();
            Arrays.sort(words);
            for (String word : words)
                head.insert(word);
            return head.maxString;
        }

        public class Trie {
            public String maxString = "";
            public Trie[] children = new Trie[26];

            public void insert(String s) {
                Trie cur = this;
                char[] chs = s.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    int idx = chs[i] - 'a';
                    if (cur.children[idx] != null) {
                        cur = cur.children[idx];
                    } else {
                        if (i < s.length() - 1) // special operation (refer to explaination above)
                            return;
                        cur.children[idx] = new Trie();
                        cur = cur.children[idx];
                        if (s.length() > maxString.length())
                            maxString = s;
                    }
                }
            }
        }

    }
}
