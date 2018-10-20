package src.com.Java;

/*
有台奇怪的打印机有以下两个特殊要求：
    打印机每次只能打印同一个字符序列。
    每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
示例 1:
输入: "aaabbb"
输出: 2
解释: 首先打印 "aaa" 然后打印 "bbb"。
示例 2:
输入: "aba"
输出: 2
解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 */
public class _664_Strange_Printer_奇怪的打印机_难 {
    class Solution {
        public int strangePrinter(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
                if (i < n - 1) {
                    dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 2;
                }
            }

            for (int len = 2; len < n; len++) {
                for (int start = 0; start + len < n; start++) {
                    dp[start][start + len] = len + 1;
                    for (int k = 0; k < len; k++) {
                        int temp = dp[start][start + k] + dp[start + k + 1][start + len];
                        dp[start][start + len] = Math.min(dp[start][start + len],
                                s.charAt(start + k) == s.charAt(start + len) ? temp - 1 : temp);
                    }
                }
            }

            return dp[0][n - 1];
        }
    }

    class Solution2 {
        public int strangePrinter(String s) {
            int n = s.length();
            int[][] f = new int[n][n];
            for (int i = n - 1; i >= 0; i--)
                for (int j = i; j < n; j++) {
                    f[i][j] = (i == j) ? 1 : 1 + f[i + 1][j];
                    for (int k = i + 1; k <= j; k++)
                        if (s.charAt(k) == s.charAt(i))
                            f[i][j] = Math.min(f[i][j], f[i + 1][k - 1] + f[k][j]);
                }
            return (n == 0 ? 0 : f[0][n - 1]);
        }
    }
}
