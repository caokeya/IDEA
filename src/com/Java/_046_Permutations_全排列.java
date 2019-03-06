package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
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
