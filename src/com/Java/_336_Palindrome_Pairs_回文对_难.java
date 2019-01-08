package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
示例 1:
输入: ["abcd","dcba","lls","s","sssll"]
输出: [[0,1],[1,0],[3,2],[2,4]] 
解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 */
public class _336_Palindrome_Pairs_回文对_难 {
    class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> ret = new ArrayList<>();
            if (words == null || words.length < 2)
                return ret;
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < words.length; i++)
                map.put(words[i], i);
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j <= words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                    String str1 = words[i].substring(0, j);
                    String str2 = words[i].substring(j);
                    if (isPalindrome(str1)) {
                        String str2rvs = new StringBuilder(str2).reverse().toString();
                        if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(map.get(str2rvs));
                            list.add(i);
                            ret.add(list);
                        }
                    }
                    if (isPalindrome(str2)) {
                        String str1rvs = new StringBuilder(str1).reverse().toString();
                        // check "str.length() != 0" to avoid duplicates
                        if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(i);
                            list.add(map.get(str1rvs));
                            ret.add(list);
                        }
                    }
                }
            }
            return ret;
        }

        private boolean isPalindrome(String str) {
            int left = 0;
            int right = str.length() - 1;
            while (left <= right) {
                if (str.charAt(left++) != str.charAt(right--))
                    return false;
            }
            return true;
        }
    }

    class SolutionTrie {
        /*
         * 这是一个Trie的高级变种题目。 对Trie的应用实在是太精妙了。
         * 总体思路是这样的： 1. 用Trie倒序存储所有的words 2. 遍历words，对于当前的currWord，
         * 按照自己的倒序在Trie里边找是否有合适的另一半，有的话就加到res里边 a. currWord 比 pairWord长，
         * 剩下的部分是palindrome就可以 b. currWord 没有 pairWord长， 停止的Trie Node里边保存了所有的符合条件的的pair
         */
        private class TrieNode {
            TrieNode[] children;
            // 该word在原来的words礼拜呢index
            // 此处兼具了isWord的功能
            int index;
            // 记录了符合这样条件的word的index
            // 1.倒序符合Trie的当前branch（当然满足，我就是在这个node看的）
            // 2.剩下没考察完的部分，是palindrome
            List<Integer> list;

            TrieNode() {
                children = new TrieNode[26];
                index = -1;
                list = new ArrayList<>();
            }
        }

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            // 倒序Trie
            TrieNode root = new TrieNode();
            for (int i = 0; i < words.length; i++)
                addWord(root, words[i], i);
            // 结果直接填充到res里边
            for (int i = 0; i < words.length; i++)
                search(words, i, root, res);
            return res;
        }

        // add word to Trie
        // index is the index in the given list
        private void addWord(TrieNode root, String word, int index) {
            // 倒序: from right to left
            for (int i = word.length() - 1; i >= 0; i--) {
                int number = word.charAt(i) - 'a';
                if (root.children[number] == null)
                    root.children[number] = new TrieNode();
                // 如果剩下的部分是palindrome，保存一下，以备后用
                if (isPalindrome(word, 0, i))
                    root.list.add(index);
                // 准备下一个letter
                root = root.children[number];
            }
            // empty 也是 palindrome
            root.list.add(index);
            // 相当于isWord = true
            root.index = index;
        }

        // 找当前words中的第i个，对应的结果，加到res里边
        private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
            String currWord = words[i];
            /* Case 1: currWord长度 >= target 长度 */
            for (int j = 0; j < currWord.length(); j++) {
                // 如果此处有word，而且不是自身，而且currWord剩下没找过的部分是palindrome
                // 那么我们就找到了一个pair
                if (root.index >= 0 && root.index != i && isPalindrome(currWord, j, currWord.length() - 1))
                    res.add(Arrays.asList(i, root.index));
                // 下一个
                root = root.children[currWord.charAt(j) - 'a'];
                // 这个Trie的branch找到底了，return
                if (root == null)
                    return;
            }

            /* Case 2: currWord长度 < target 长度 */
            // 看看当前root的list里边，找与currWord不同的
            for (int entry : root.list) {
                if (i == entry)
                    continue;
                res.add(Arrays.asList(i, entry));
            }
        }

        // check whether substring in range [i,j] of word is palindrome
        private boolean isPalindrome(String word, int i, int j) {
            while (i < j)
                if (word.charAt(i++) != word.charAt(j--))
                    return false;
            return true;
        }
    }

}
