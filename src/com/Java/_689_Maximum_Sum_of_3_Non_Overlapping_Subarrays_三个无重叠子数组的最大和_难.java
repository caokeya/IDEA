package com.Java;

/*
给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。
每个子数组的长度为k，我们要使这3*k个项的和最大化。
返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。
示例:
输入: [1,2,1,2,6,7,5,1], 2
输出: [0, 3, 5]
解释: 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 */
public class _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays_三个无重叠子数组的最大和_难 {
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length, maxsum = 0;
            int[] sum = new int[n + 1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
            for (int i = 0; i < n; i++)
                sum[i + 1] = sum[i] + nums[i];
            // DP for starting index of the left max sum interval
            for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
                if (sum[i + 1] - sum[i + 1 - k] > tot) {
                    posLeft[i] = i + 1 - k;
                    tot = sum[i + 1] - sum[i + 1 - k];
                } else
                    posLeft[i] = posLeft[i - 1];
            }
            // DP for starting index of the right max sum interval
            // caution: the condition is ">= tot" for right interval, and "> tot" for left
            // interval
            posRight[n - k] = n - k;
            for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; i--) {
                if (sum[i + k] - sum[i] >= tot) {
                    posRight[i] = i;
                    tot = sum[i + k] - sum[i];
                } else
                    posRight[i] = posRight[i + 1];
            }
            // test all possible middle interval
            for (int i = k; i <= n - 2 * k; i++) {
                int l = posLeft[i - 1], r = posRight[i + k];
                int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
                if (tot > maxsum) {
                    maxsum = tot;
                    ans[0] = l;
                    ans[1] = i;
                    ans[2] = r;
                }
            }
            return ans;
        }
    }
}
