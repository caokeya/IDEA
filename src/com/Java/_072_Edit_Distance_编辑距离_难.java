package src.com.Java;

public class _072_Edit_Distance_编辑距离_难 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int w1 = word1.length();
            int w2 = word2.length();
            char[] ch1 = word1.toCharArray();
            char[] ch2 = word2.toCharArray();
            int[][] dp = new int[w1 + 1][w2 + 1];
            for (int i = 0; i <= w1; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= w2; j++) {
                dp[0][j] = j;
            }
            for (int i = 0; i < w1; i++) {
                for (int j = 0; j < w2; j++) {
                    if (ch1[i] == ch2[j]) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else {
                        dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]));
                    }
                }
            }
            return dp[w1][w2];
        }
    }
}
