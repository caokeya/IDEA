package src.com.Java;
/*
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
 */
public class _152_Maximum_Product_Subarray_乘积最大子序列 {
    class Solution {
        public int maxProduct(int[] nums) {
            int currMax = nums[0];
            int currMin = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int temp = currMin;
                    currMin = currMax;
                    currMax = temp;
                }

                currMax = Math.max(nums[i], currMax * nums[i]);
                currMin = Math.min(nums[i], currMin * nums[i]);

                max = Math.max(max, currMax);
            }

            return max;
        }
    }
}
