package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _039_Combination_Sum_组合总和 {
    public class Solution {
        public List<List<Integer>> combinationSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            getResult(result, new ArrayList<Integer>(), nums, target, 0);

            return result;
        }

        private void getResult(List<List<Integer>> result, List<Integer> cur, int nums[], int target, int start) {
            if (target > 0) {
                for (int i = start; i < nums.length && target >= nums[i]; i++) {
                    cur.add(nums[i]);
                    getResult(result, cur, nums, target - nums[i], i);
                    cur.remove(cur.size() - 1);
                } 
            }
            else if (target == 0) {
                result.add(new ArrayList<Integer>(cur));
            } 
        }
    }
}
