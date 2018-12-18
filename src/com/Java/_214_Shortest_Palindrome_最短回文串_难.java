package src.com.Java;

/*
 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 示例 1:
 输入: "aacecaaa"
 输出: "aaacecaaa"
 示例 2:
 输入: "abcd"
 输出: "dcbabcd"
 */
public class _214_Shortest_Palindrome_最短回文串_难 {
    class Solution {
        public String shortestPalindrome(String s) {
            if (s == null || s.length() < 2)
                return s;
            int len = s.length();
            int j = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(j) == s.charAt(i))
                    j++;
            }
            if (j == s.length())
                return s;
            String suffix = s.substring(j);
            return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
        }
    }
}
