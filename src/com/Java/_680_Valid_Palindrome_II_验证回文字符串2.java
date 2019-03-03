package com.Java;

/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
示例 1:
输入: "aba"
输出: True
示例 2:
输入: "abca"
输出: True
解释: 你可以删除c字符。
 */
public class _680_Valid_Palindrome_II_验证回文字符串2 {
    class Solution {
        public boolean validPalindrome(String s) {
            if (s.length() == 0)
                return true;
            int start = 0, end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
                }
                start++;
                end--;
            }
            return true;
        }

        public boolean isPalindrome(String s, int start, int end) {
            if (s.length() == 0)
                return true;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
            return true;
        }
    }
}
