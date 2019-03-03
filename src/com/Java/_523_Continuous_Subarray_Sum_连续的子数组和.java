package com.Java;

import java.util.HashMap;
import java.util.Map;

/*
给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
示例 1:
输入: [23,2,4,6,7], k = 6
输出: True
解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
示例 2:
输入: [23,2,6,4,7], k = 6
输出: True
解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 */
public class _523_Continuous_Subarray_Sum_连续的子数组和 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (k != 0)
                    sum = sum % k;
                if (map.containsKey(sum)) {
                    if (i - map.get(sum) > 1)
                        return true;
                } else
                    map.put(sum, i);
            }
            return false;
        }
    }
}
