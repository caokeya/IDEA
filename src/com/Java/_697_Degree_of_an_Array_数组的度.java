package com.Java;

import java.util.HashMap;
import java.util.Map;

/*
给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
示例 1:
输入: [1, 2, 2, 3, 1]
输出: 2
解释: 
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2:
输入: [1,2,2,3,1,4,2]
输出: 6
 */
public class _697_Degree_of_an_Array_数组的度 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 创建一个map,KEY是数组中的元素， Value是一个数组{出现次数， 第一次出现位置， 最后一次出现位置}
            Map<Integer, int[]> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new int[] { 1, i, i });
                } else {
                    int[] temp = map.get(nums[i]);
                    temp[0]++;
                    temp[2] = i;
                }
            }
            int result = nums.length;
            int degree = 0;
            for (int[] temp : map.values()) {
                if (temp[0] > degree) {
                    degree = temp[0];
                    result = temp[2] - temp[1] + 1;
                } else if (temp[0] == degree) {
                    result = Math.min(result, temp[2] - temp[1] + 1);
                }
            }
            return result;
        }
    }
}
