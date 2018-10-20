package src.com.Java;

/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。
示例 1:
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class _581_Shortest_Unsorted_Continuous_Subarray_最短无序连续子数组 {
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // 1,3,2,2,2,2
            // 找到右边界：从左往右搜索，找到最右边的，小于left max的index
            int max = nums[0], right = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
                if (nums[i] < max) {
                    right = i;
                }
            }
            // 找到左边界，从右往左搜索，找到最左边的，大于right min的index
            int min = nums[nums.length - 1], left = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                min = Math.min(min, nums[i]);
                if (nums[i] > min) {
                    left = i;
                }
            }

            return right - left + 1;
        }
    }
}
