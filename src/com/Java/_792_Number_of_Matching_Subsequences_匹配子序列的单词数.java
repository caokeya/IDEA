package src.com.Java;

import java.util.*;

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
            Map<Character, Queue<String>> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < S.length(); i++) {
                map.putIfAbsent(S.charAt(i), new LinkedList<>());
            }
            for (String word : words) {
                char c = word.charAt(0);
                if (map.containsKey(c)) {
                    map.get(c).offer(word);
                }
            }
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                Queue<String> q = map.get(c);
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    String str = q.poll();
                    if (str.length() == 1) {
                        count++;
                    } else {
                        if (map.containsKey(str.charAt(1))) {
                            map.get(str.charAt(1)).add(str.substring(1));
                        }
                    }
                }
            }
            return count;
        }
    }

    class Solution2 {
        public int numMatchingSubseq(String S, String[] words) {
            int count = 0;
            HashMap<String, Boolean> subSeqCached = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (subSeqCached.containsKey(words[i])) {
                    if (subSeqCached.get(words[i]))
                        count++;
                    continue;
                }
                if (isSubSeq(S, words[i])) {
                    subSeqCached.put(words[i], true);
                    count++;
                } else {
                    subSeqCached.put(words[i], false);
                }
            }
            return count;
        }

        private boolean isSubSeq(String large, String small) {
            int smallIndex = 0;
            int smallLen = small.length();
            for (int i = 0; i < large.length(); i++) {
                if (large.charAt(i) == small.charAt(smallIndex)) {
                    if (smallIndex + 1 == smallLen) {
                        return true;
                    }
                    smallIndex++;
                }
            }
            return false;
        }
    }
}
