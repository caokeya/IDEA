package src.com.Java;

import java.util.ArrayList;
import java.util.List;

public class _046_Permutations_全排列 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            helper(0, res, nums);
            return res;
        }

        public void helper(int start, List<List<Integer>> res, int[] nums) {
            if (start >= nums.length) {
                List<Integer> list = new ArrayList<Integer>();
                for (Integer i : nums)
                    list.add(i);
                res.add(list);
                return;
            }
            for (int i = start; i < nums.length; i++) {
                swap(nums, i, start);
                helper(start + 1, res, nums);
                swap(nums, i, start);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }
}
