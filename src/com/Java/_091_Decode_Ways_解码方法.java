package src.com.Java;

public class _091_Decode_Ways_解码方法 {
    class Solution {
        public int numDecodings(String s) {
            int len = s.length();
            if (len == 0)
                return 0;
            int[] dp = new int[len + 1];
            dp[len] = 1;
            dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;

            for (int i = len - 2; i >= 0; i--) {
                if (s.charAt(i) == '0')
                    continue;
                else
                    dp[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }

            return dp[0];

        }

    }
}
