package src.com.Java;

import java.util.Arrays;

/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
示例 1:
输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:
输入: n = 13
输出: 2
解释: 13 = 4 + 9.
*/
public class _279_Perfect_Squares_将n拆为完全平方数的和 {
    /*
    dp[0] = 0
    dp[1] = dp[0]+1 = 1
    dp[2] = dp[1]+1 = 2
    dp[3] = dp[2]+1 = 3
    dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
          = Min{ dp[3]+1, dp[0]+1 }
          = 1
    dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
          = Min{ dp[4]+1, dp[1]+1 }
          = 2
    dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     */
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                int j = 1;
                while (i - j * j >= 0) {
                    min = Math.min(min, dp[i - j * j] + 1);
                    j++;
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }

    class Solution2 {
        public int numSquares(int n) {
            //base case
            if (n < 4) return n;
            // If n is a perfect square, return 1.
            if (isSquare(n)) return 1;
            // The result is 4 if and only if n can be written in the
            // form of 4^k*(8*m + 7). Please refer to
            // Legendre's three-square theorem.
            while ((n & 3) == 0) {// n%4 == 0
                n >>= 2;
            }
            if ((n & 7) == 7) { // n%8 == 7
                return 4;
            }

            // Check whether 2 is the result.
            int sqrt_n = (int) (Math.sqrt(n));
            for (int i = 1; i <= sqrt_n; i++) {
                if (isSquare(n - i * i)) return 2;
            }
            return 3;
        }

        public boolean isSquare(int n) {
            int sqrt_n = (int) Math.sqrt(n);
            return sqrt_n * sqrt_n == n;
        }
    }
}
