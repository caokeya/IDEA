package src.com.Java;

import java.util.Arrays;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
*/
public class _300_Longest_Increasing_Subsequence_最长上升子序列 {
    //10  res = 0 i = 0 j = 0
    //9   res = 1 i = 0 j = 0 mid = 0
    //2   res = 1 i = 0 j = 0 mid = 0
    //5   res = 1 i = 1 j = 1 mid = 0
    //3   res = 2
    //7   res = 2 i = 2 j = 2 mid = 1
    //101 res = 3 i = 2 j = 3 mid = 1
    //18  res = 4 i = 3 j = 3 mid = 3
    //res == 排好序的size i, j 相当于tails的起点，终点
    //time : O(nlogn)
    //space : O(n)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int res = 0;
            for (int num : nums) {
                int i = 0, j = res;
                while (i != j) {
                    int mid = (i + j) / 2;
                    if (tails[mid] < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }
                tails[i] = num;
                if (i == res) res++;
            }
            return res;
        }
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
            }
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    // i = 2 j = 0
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
