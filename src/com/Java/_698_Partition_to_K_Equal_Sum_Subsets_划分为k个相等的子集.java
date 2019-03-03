package com.Java;

import java.util.Arrays;

/*
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
示例 1：
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 */
public class _698_Partition_to_K_Equal_Sum_Subsets_划分为k个相等的子集 {
    /*
           * 假设sum是nums[]的和。dfs过程是找到nums[]的一个子集，它的和等于sum/k。 我们使用访问过的数组[]来记录nums[]中使用的元素。
           * 每次当我们得到cur_sum = sum/k时，我们将从nums[]中的位置0开始查找尚未使用的元素，并找到另一个cur_sum = sum/k。
           * 当sum = 0时，我的方法是使用cur_num记录当前子集中的元素数量。
           * 只有当cur_sum = sum/k && cur_num > 0时，我们才能启动另一个查找进程。
     */
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int num : nums)
                sum += num;
            if (sum % k != 0)
                return false;
            int count = 0;
            int target = sum / k;
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);

            while (count < k) {
                if (helper(nums, visited, nums.length - 1, target)) {
                    count++;
                } else {
                    break;
                }
            }

            return count == k;
        }

        private boolean helper(int[] nums, boolean[] visited, int index, int remaining) {
            if (remaining == 0)
                return true;
            if (remaining <= 0)
                return false;
            for (int i = index; i >= 0; i--) {
                if (visited[i])
                    continue;
                visited[i] = true;
                if (helper(nums, visited, i - 1, remaining - nums[i])) {
                    return true;
                } else {
                    visited[i] = false;
                }
            }

            return false;
        }
    }
}
