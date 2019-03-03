package com.Java;

import java.util.HashMap;

/*
给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组。
示例 1:
输入: [0,1]
输出: 2
说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
示例 2:
输入: [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 */
public class _525_Contiguous_Array_连续数组 {
    public class Solution {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            int zero = 0;
            int one = 0;
            int len = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zero++;
                } else {
                    one++;
                }

                if (map.containsKey(zero - one)) {
                    len = Math.max(len, i - map.get(zero - one));
                } else {
                    map.put(zero - one, i);
                }
            }

            return len;
        }
    }

}
