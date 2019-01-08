package src.com.Java;

/*
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
示例 :
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class _343_Integer_Break_整数拆分 {
    class SolutionDP {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(i - j, dp[i - j]) * Math.max(j, dp[j]));
                }
            }
            return dp[n];
        }
    }

    public class Solution {
        public int integerBreak(int n) {
            if (n == 2)
                return 1;
            if (n == 3)
                return 2;
            int product = 1;
            while (n > 4) {
                product *= 3;
                n -= 3;
            }
            product *= n;

            return product;
        }
    }
}
