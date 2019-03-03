package com.Java;

/*
给定一个整数数组 nums ，你可以对它进行一些操作。
每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
示例 1:
输入: nums = [3, 4, 2]
输出: 6
解释: 
删除 4 来获得 4 个点数，因此 3 也被删除。
之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
示例 2:
输入: nums = [2, 2, 3, 3, 3, 4]
输出: 9
解释: 
删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
总共获得 9 个点数。
 */
public class _740_Delete_and_Earn_删除与获得点数 {
    class Solution {
        public int deleteAndEarn(int[] nums) {

            int n = 10001;
            int[] values = new int[n];
            for (int num : nums)
                values[num] += num;

            int take = 0, skip = 0;
            for (int i = 0; i < n; i++) {
                int take_i = skip + values[i];
                int skip_i = Math.max(skip, take);
                take = take_i;
                skip = skip_i;
            }
            return Math.max(take, skip);
        }
    }

    class Solution2 {
        public int deleteAndEarn(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int max = 0;
            for (int num : nums)
                max = Math.max(max, num);
            int[] dp = new int[max + 1];

            for (int num : nums)
                dp[num] += num;

            for (int i = 2; i <= max; i++)
                dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);
            return dp[max];
        }
    }
}
