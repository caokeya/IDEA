package com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
如果有多个目标子集，返回其中任何一个均可。
示例 1:
输入: [1,2,3]
输出: [1,2] (当然, [1,3] 也正确)
 */
public class _368_Largest_Divisible_Subset_最大整除子集 {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> result = new ArrayList<Integer>();
            if (nums == null || nums.length == 0)
                return result;
            Arrays.sort(nums);
            int[] dp = new int[nums.length];
            int[] index = new int[nums.length];
            Arrays.fill(dp, 1);
            Arrays.fill(index, -1);

            int maxIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        index[i] = j;
                        if (dp[i] > dp[maxIndex])
                            maxIndex = i;
                    }
                }
            }

            int i = maxIndex;

            while (i >= 0) {
                result.add(0, nums[i]);
                i = index[i];
            }
            return result;
        }
    }
}
