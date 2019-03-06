package src.src.com.Java;

/*
 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 示例:
 输入: s = 7, nums = [2,3,1,2,4,3]
 输出: 2
 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
*/
public class _209_Minimum_Size_Subarray_Sum_长度最小的子数组 {
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            //使用滑动窗口，left保存起始位置的指针
            int left = 0, sum = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                while (sum >= s) {
                    min = Math.min(min, i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return Integer.MAX_VALUE == min ? 0 : min;
        }
    }
}
