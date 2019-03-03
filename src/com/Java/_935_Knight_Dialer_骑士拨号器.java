package com.Java;
/*
国际象棋中的骑士可以按下图所示进行移动：
这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。
每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。
你能用这种方式拨出多少个不同的号码？
因为答案可能很大，所以输出答案模 10^9 + 7。
示例 1：
输入：1
输出：10
示例 2：
输入：2
输出：20
示例 3：
输入：3
输出：46
 */
public class _935_Knight_Dialer_骑士拨号器 {
    class Solution {
        public int knightDialer(int N) {
            int[][] dirs = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
            int[][] dp = new int[N + 1][10];
            for (int j = 0; j < dp[0].length; j++) {
                dp[1][j] = 1;
            }
            int mod = (int) 1e9 + 7;
            for (int i = 2; i < dp.length; i++)
                for (int j = 0; j < dp[0].length; j++) {

                    int[] dir = dirs[j]; // Where j comes from
                    for (int num : dir) {
                        dp[i][j] += dp[i - 1][num];
                        dp[i][j] %= mod;
                    }
                }
            int count = 0;
            for (int i = 0; i < dp[0].length; i++) {
                count += dp[N][i];
                count %= mod;
            }
            return count;
        }
    }
}
