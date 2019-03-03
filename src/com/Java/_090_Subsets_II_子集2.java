package com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class _090_Subsets_II_子集2 {
    class Solution {
        // backtracking
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            backtrack(result, nums, 0, new ArrayList<Integer>());
            return result;
        }

        // backtracking function
        private void backtrack(List<List<Integer>> result, int[] nums, int index, List<Integer> temp) {
            result.add(new ArrayList<Integer>(temp));
            for (int i = index; i < nums.length; i++) {
                if (i != index && nums[i] == nums[i - 1])
                    continue;
                temp.add(nums[i]);
                backtrack(result, nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
