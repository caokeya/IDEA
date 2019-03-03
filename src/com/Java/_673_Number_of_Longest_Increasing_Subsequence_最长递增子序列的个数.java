package com.Java;

/*
给定一个未排序的整数数组，找到最长递增子序列的个数。
示例 1:
输入: [1,3,5,4,7]
输出: 2
解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
示例 2:
输入: [2,2,2,2,2]
输出: 5
解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 */
public class _673_Number_of_Longest_Increasing_Subsequence_最长递增子序列的个数 {
    /*
            其思想是使用两个数组len[n]和cnt[n]分别记录这些序列中以nums[i]结尾的递增子序列的最大长度和对应数目。那就是:
        len[i]:以nums[i]结尾的最长递增子序列的长度。
        cnt[i]:以数字[i]结尾的最长递增子序列的数目。
            结果是每个cnt[i]的和，对应的len[i]是最大长度。
     */
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length, res = 0, max_len = 0;
            int[] len = new int[n], cnt = new int[n];
            for (int i = 0; i < n; i++) {
                len[i] = cnt[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (len[i] == len[j] + 1)
                            cnt[i] += cnt[j];
                        if (len[i] < len[j] + 1) {
                            len[i] = len[j] + 1;
                            cnt[i] = cnt[j];
                        }
                    }
                }
                if (max_len == len[i])
                    res += cnt[i];
                if (max_len < len[i]) {
                    max_len = len[i];
                    res = cnt[i];
                }
            }
            return res;

        }
    }

    class Solution2 {
        public int findNumberOfLIS(int[] nums) {
            // Time Complexity: O(N^2)O(N^2) where NN is the length of nums. There are two
            // for-loops and the work inside is O(1).
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int[] dp = new int[nums.length];
            int[] cnt = new int[nums.length];
            int maxLength = 0;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                cnt[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j];
                        } else if (dp[i] == dp[j] + 1) {
                            cnt[i] += cnt[j];
                        }
                    }
                }
            }

            for (int length : dp) {
                maxLength = Math.max(length, maxLength);
            }

            for (int i = 0; i < nums.length; i++) {
                if (dp[i] == maxLength) {
                    count += cnt[i];
                }
            }
            return count;
        }
    }
}
