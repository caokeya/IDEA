package src.com.Java;

/*
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
示例 1:
输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class _643_Maximum_Average_Subarray_I_子数组最大平均数 {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double sum = 0;
            for (int i = 0; i < k; i++)
                sum += nums[i];
            double res = sum;
            for (int i = k; i < nums.length; i++) {
                sum += nums[i] - nums[i - k];
                res = Math.max(res, sum);
            }
            return res * 1.0 / k;
        }
    }
}
