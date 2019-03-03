package com.Java;

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
示例 1:
输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class _198_House_Robber_打家劫舍 {
    /*
     * dp[i] = max{dp[i - 1], dp[i - 2] + value[i]} 抢不抢第i间房子，取决于第i-1间房子抢了没抢： 
     * 如果第i-1间抢了，那当前(第i间房)就绝不能抢； dp[i] = dp[i - 1] 
     * 如果第i-1间没抢，那当前(第i间房)可抢可不抢； dp[i] = max(value[i] + dp[i - 2], dp[i - 1]) 合并两个得到上面的状态转移方程。
     */
    public class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0)
                return 0;
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i < nums.length + 1; i++) {
                dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
            }
            return dp[nums.length];
        }
    }
}
