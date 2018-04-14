package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//利用HashMap对两个数字进行求和得到与目标值相等的数字的位置

public class twosumTotarget {

	public static void main(String[] args) {
		int [] a = new int []{2,3,6};
		int b = 8;
		int [] c = twoSum(a,b);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
	}
	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null || nums.length < 2) {
			return res;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp)) {
				res[0] = map.get(temp);
				res[1] = i;
				return res;
			} else {
				map.put(nums[i], i);
			}
		}
		return res;
	}
}
