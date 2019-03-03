package com.Java;
import java.util.Arrays;

//三个数的和最接近目标值的组合
/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class _016_Three_Sum_Closest_三个数的和最接近目标值的组合 {

	class Solution {
		public int threeSumClosest(int[] nums, int target) {
			int len = nums.length;
			if (nums == null || len < 3)
				return 0;

			int min = Integer.MAX_VALUE;
			int val = 0;
			Arrays.sort(nums);
			for (int i = 0; i <= len - 3; i++) {
				int start = i + 1;
				int end = len - 1;
				while (start < end) {
					int sum = nums[i] + nums[start] + nums[end];
					if (Math.abs(target - sum) < min) {
						min = Math.abs(target - sum);
						val = sum;
					}
					if (target == sum) {
						return val;
					} else if (sum > target) {
						end--;
					} else if (sum < target) {
						start++;
					}
				}
			}
			return val;
		}
	}

}
