package com.company;

import java.util.HashMap;
import java.util.Map;

public class _033_Search_in_Rotated_Sorted_Array_搜索旋转排序数组 {
    class Solution {
        public int search(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    class SolutionMap {
        public int search(int[] nums, int target) {
            Map<Integer, Integer> m = new HashMap<>();

            if (nums.length == 0)
                return -1;

            for (int i = 0; i < nums.length; i++)
                m.put(nums[i], i);

            return (m.containsKey(target)) ? m.get(target) : -1;
        }
    }
}
