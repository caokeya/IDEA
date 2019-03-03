package com.Java;
/*
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。
说明:
    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
 */
public class _044_Wildcard_Matching_通配符匹配_难 {
    public class Solution {
        // O(n^2) DP solution with dp[][] matric transposed:
        public boolean isMatch(String s, String p) {
            int sL = s.length(), pL = p.length();

            boolean[][] dp = new boolean[pL + 1][sL + 1];
            dp[0][0] = true;

            for (int i = 1; i <= pL; i++) {
                boolean flag = false; // The flag is moved here;

                for (int j = 0; j <= sL; j++) {
                    flag = flag || dp[i - 1][j];
                    char c = p.charAt(i - 1);

                    if (c != '*') {
                        dp[i][j] = j > 0 && dp[i - 1][j - 1] && (c == '?' || c == s.charAt(j - 1));
                    } else {
                        // For k>=0 and k<=j, if any dp[i-1][k] is true,
                        // then '*' will match the rest sequence in s after index k;
                        dp[i][j] = i == 1 || flag;
                    }
                }
            }

            return dp[pL][sL];
        }
    }
}
