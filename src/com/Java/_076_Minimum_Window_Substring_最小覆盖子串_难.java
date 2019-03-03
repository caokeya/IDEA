package com.Java;
/*
给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
示例：
输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
 */
public class _076_Minimum_Window_Substring_最小覆盖子串_难 {
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || t.length() == 0)
                return "";

            int count = t.length();

            int[] map = new int[128];
            for (char c : t.toCharArray())
                map[c]++;

            int left = 0, right = 0, head = 0, minL = Integer.MAX_VALUE;
            while (right < s.length()) {
                if (map[s.charAt(right++)]-- > 0)
                    count--;
                while (count == 0) {
                    if (right - left < minL) {
                        minL = right - left;
                        head = left;
                    }
                    if (map[s.charAt(left++)]++ == 0)
                        count++;
                }
            }
            return minL == Integer.MAX_VALUE ? "" : s.substring(head, head + minL);
        }
    }
}
