package src.com.Java;
/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */
public class _032_Longest_Valid_Parentheses_最长有效括号_难 {
    public class Solution {
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            int result = 0;
            int leftCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    leftCount++;
                } else if (leftCount > 0) {
                    dp[i] = dp[i - 1] + 2;
                    dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                    result = Math.max(result, dp[i]);
                    leftCount--;
                }
            }
            return result;
        }
    }
}
