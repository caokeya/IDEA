package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _040_Combination_Sum_II_组合总和2 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();
            Arrays.sort(nums); // need sort to make this work.
            combination(nums, target, 0, comb, ans);
            return ans;
        }

        private void combination(int[] nums, int target, int start, List<Integer> comb, List<List<Integer>> ans) {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) // remove duplicates.
                    continue;
                if (nums[i] == target) {
                    // recursion exit.
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(nums[i]);
                    ans.add(newComb);
                } else if (nums[i] < target) {
                    // continue to look for the rest.
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(nums[i]);
                    combination(nums, target - nums[i], i + 1, newComb, ans);
                } else
                    break; // invalid path, return nothing.
            }
        }
    }
}
