package com.Java;

/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
示例 1:
输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
 */
public class _322_Coin_Change_零钱兑换 {
    class Solution {
        public int coinChange(int[] coins, int amount) {

            int dp[] = new int[amount + 1];
            for (int i = 0; i <= amount; i++) {
                dp[i] = amount + 1;
            }
            dp[0] = 0;
            int coin_num = coins.length;
            for (int i = 1; i < amount + 1; i++) {
                for (int j = 0; j < coin_num; j++) {
                    if (i >= coins[j]) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);//当前金额所需硬币=当前金额减去选某一张硬币的余额所需硬币+1
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
