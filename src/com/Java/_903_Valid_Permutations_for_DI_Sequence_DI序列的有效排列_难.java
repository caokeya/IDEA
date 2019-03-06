package src.src.com.Java;

/*
我们给出 S，一个源于 {'D', 'I'} 的长度为 n 的字符串 。（这些字母代表 “减少” 和 “增加”。）
有效排列 是对整数 {0, 1, ..., n} 的一个排列 P[0], P[1], ..., P[n]，使得对所有的 i：
    如果 S[i] == 'D'，那么 P[i] > P[i+1]，以及；
    如果 S[i] == 'I'，那么 P[i] < P[i+1]。
有多少个有效排列？因为答案可能很大，所以请返回你的答案模 10^9 + 7.
示例：
输入："DID"
输出：5
解释：
(0, 1, 2, 3) 的五个有效排列是：
(1, 0, 3, 2)
(2, 0, 3, 1)
(2, 1, 3, 0)
(3, 0, 2, 1)
(3, 1, 2, 0)
 */
public class _903_Valid_Permutations_for_DI_Sequence_DI序列的有效排列_难 {
    /*
    dp[i][j]是指前i + 1位的可能排列数，其中i + 1位是 第j + 1小的数。
    对于“I”，我们计算数组的前缀和
    对于“D”，我们计算数组的后缀和
     */
    class Solution {
        public int numPermsDISequence(String S) {
            int n = S.length(), mod = (int) 1e9 + 7;
            int[][] dp = new int[n + 1][n + 1];
            for (int j = 0; j <= n; j++)
                dp[0][j] = 1;
            for (int i = 0; i < n; i++)// i 代表前 i 位数
                if (S.charAt(i) == 'I')
                    for (int j = 0, cur = 0; j < n - i; j++) {
                        cur = (cur + dp[i][j]) % mod;
                        dp[i + 1][j] = cur;
                    }
                else if (S.charAt(i) == 'D') {
                    for (int j = n - i - 1, cur = 0; j >= 0; j--) {
                        cur = (cur + dp[i][j + 1]) % mod;
                        dp[i + 1][j] = cur;
                    }
                }
            return dp[n][0];
        }
    }
}
