package src.com.Java;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class _053_Maximum_Subarray_最大子序和 {
    class Solution {
        public int maxSubArray(int[] A) {
            int n = A.length;
            int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
            dp[0] = A[0];
            int max = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
