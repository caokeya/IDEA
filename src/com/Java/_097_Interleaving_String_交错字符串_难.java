package src.com.Java;

/*
给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
示例 1:
输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
 */
public class _097_Interleaving_String_交错字符串_难 {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int alen = s1.length();
            int blen = s2.length();
            int clen = s3.length();
            if (alen + blen != clen) {
                return false;
            }
            // i to represent i-th char in string
            boolean[][] dp = new boolean[alen + 1][blen + 1];
            for (int i = 0; i <= alen; i++) {
                for (int j = 0; j <= blen; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    } else {
                        dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
                                || dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    }
                }
            }
            return dp[alen][blen];
        }
    }
}
