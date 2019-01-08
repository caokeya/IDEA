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
        /*核心点是：要求的是substring，
        因此，如果发现一个string中间有一个char是小于k次的，那么最长的substring只可能是这个char左右两边的两个substring。
            1. 统计当前string中每个字符出现的次数，用少于k次的字符作为分隔符，把string分割成几个substring，
               只有这些substring才有可能是满足条件的substring。
            2. recurse on substrings，找到结果中最大的一个即可。
        终止条件：substring长度已经小于k，substring已空，或 k<=1的时候都可以直接返回确定值了。
        */
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
