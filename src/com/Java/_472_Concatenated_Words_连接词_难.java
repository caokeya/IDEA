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
    public class Solution {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> result = new ArrayList<>();
            Set<String> preWords = new HashSet<>();
            Arrays.sort(words, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s1.length() - s2.length();
                }
            });

            for (int i = 0; i < words.length; i++) {
                if (canForm(words[i], preWords)) {
                    result.add(words[i]);
                }
                preWords.add(words[i]);
            }

            return result;
        }

        private boolean canForm(String word, Set<String> dict) {
            if (dict.isEmpty())
                return false;
            boolean[] dp = new boolean[word.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= word.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (!dp[j])
                        continue;
                    if (dict.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[word.length()];
        }
    }

    class Solution2 {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> res = new LinkedList<>();
            Node root = new Node();
            for (String w : words) {
                Node cur = root;
                for (char c : w.toCharArray()) {
                    if (cur.nodes[c - 'a'] == null)
                        cur.nodes[c - 'a'] = new Node();
                    cur = cur.nodes[c - 'a'];
                }
                cur.end = true;
            }
            for (String w : words) {
                char[] ch = w.toCharArray();
                if (helper(root, ch, 0))
                    res.add(w);
            }
            return res;
        }

        public boolean helper(Node root, char[] ch, int index) {
            // if (index == ch.length)
            // return ch.length != 0;
            Node cur = root;
            int origin = index;
            while (index < ch.length) {
                if (cur.nodes[ch[index] - 'a'] == null)
                    return false;
                cur = cur.nodes[ch[index++] - 'a'];
                if (cur.end && index != ch.length && helper(root, ch, index))
                    return true;
            }
            return origin != 0 && cur.end ? true : false;
        }

        class Node {
            Node[] nodes = new Node[26];
            boolean end;
        }
    }
}
