package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
