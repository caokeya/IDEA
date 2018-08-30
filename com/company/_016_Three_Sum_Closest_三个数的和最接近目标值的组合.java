package com.company;
import java.util.Arrays;

//三个数的和最接近目标值的组合

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
