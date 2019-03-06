package src.com.Java;

/*
找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
示例 2:
输入:
s = "ababbc", k = 2
输出:
5
最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
public class _395_Longest_Substring_with_At_Least_K_Repeating_Characters_至少有K个重复字符的最长子串 {
    class Solution {
        public int longestSubstring(String s, int k) {
            if (s.length() == 0 || k == 0)
                return 0;
            char[] ch = s.toCharArray();
            int[] counts = new int[26];
            for (char c : ch)
                counts[c - 'a']++;
            boolean isWhole = true;
            for (int count : counts) {
                if (count > 0 && count < k)
                    isWhole = false;
            }
            if (isWhole)
                return ch.length;
            int max = 0, i = 0, start = 0;
            while (i < ch.length) {
                if (counts[ch[i] - 'a'] < k) {
                    max = Math.max(max, longestSubstring(s.substring(start, i), k));
                    start = i + 1;
                }
                i++;
            }
            return Math.max(max, longestSubstring(s.substring(start), k));
        }
    }
}
