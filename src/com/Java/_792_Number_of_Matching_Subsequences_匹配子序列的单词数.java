package src.com.Java;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
示例:
输入: 
S = "abcde"
words = ["a", "bb", "acd", "ace"]
输出: 3
解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 */
public class _792_Number_of_Matching_Subsequences_匹配子序列的单词数 {
    class Solution {
        public int numMatchingSubseq(String S, String[] words) {
            Map<Character, Deque<String>> map = new HashMap<>();
            for (char c = 'a'; c <= 'z'; c++) {
                map.putIfAbsent(c, new LinkedList<String>());
            }
            for (String word : words) {
                map.get(word.charAt(0)).addLast(word);
            }
            int count = 0;
            for (char c : S.toCharArray()) {
                Deque<String> queue = map.get(c);
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String word = queue.removeFirst();
                    if (word.length() == 1)
                        count++;
                    else
                        map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
            return count;
        }
    }

    class Solution2 {
        public int numMatchingSubseq(String S, String[] words) {
            int count = 0;
            Set<String> valid = new HashSet<String>();
            Set<String> invalid = new HashSet<String>();

            for (String word : words) {
                if (valid.contains(word)) {
                    count++;
                } else if (invalid.contains(word)) {
                    continue;
                } else {
                    if (isSubsequence(word, S)) {
                        valid.add(word);
                        count++;
                    } else {
                        invalid.add(word);
                    }
                }
            }

            return count;
        }

        public boolean isSubsequence(String s, String t) {
            int i = 0, j = 0;

            if (s.length() == 0)
                return true;

            while (j < t.length()) {
                if (s.charAt(i) == t.charAt(j))
                    i++;
                j++;

                if (i == s.length()) {
                    return true;
                }
            }

            return false;
        }
    }
}
