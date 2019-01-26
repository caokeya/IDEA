package src.com.Java;

import java.util.Arrays;

/*
给定一个字符串 S，计算 S 的不同非空子序列的个数。
因为结果可能很大，所以返回答案模 10^9 + 7.
示例 1：
输入："abc"
输出：7
解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
示例 2：
输入："aba"
输出：6
解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
示例 3：
输入："aaa"
输出：3
解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 */
public class _940_Distinct_Subsequences_II_不同的子序列_II_难 {
    class Solution {
        public int distinctSubseqII(String S) {
            int n = S.length(), M = (int) 1e9 + 7, result = 0;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (S.charAt(j) != S.charAt(i)) {
                        dp[i] += dp[j];
                        dp[i] %= M;
                    }
                }
                result += dp[i];
                result %= M;
            }
            return result;
        }
    }
    class Solution2 {
        /*
        我们可以用sum来表示sum(dp[0]，…)， dp[i - 1])。
        count数组，其中count[S.charAt(i) - 'a']表示以S.charAt(i)结尾的子序列的计数。
        那么dp[i] = sum - count[S.charAt(i) - 'a']。
         */
        public int distinctSubseqII(String S) {
            int n = S.length(), M = (int)1e9 + 7;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int[] count = new int[26];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int index = S.charAt(i) - 'a';
                dp[i] += sum - count[index];
                dp[i] = (dp[i] + M) % M;
                sum = (sum + dp[i]) % M;
                count[index] = (count[index] + dp[i]) % M;
            }
            return sum;
        }
    }
}
