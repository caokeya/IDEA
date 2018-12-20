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
            List<List<Integer>> masterList = new ArrayList<>();
            if (nums.length == 0) {
                return masterList;
            }

            permute(nums, 0, new ArrayList<Integer>(), masterList);
            return masterList;
        }

        public void permute(int[] nums, int index, List<Integer> list, List<List<Integer>> masterList) {
            // Recursively loop through numbers
            if (list.size() == nums.length) {
                masterList.add(list);
                return;
            }

            for (int i = 0; i <= list.size(); i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i, nums[index]);
                permute(nums, index + 1, newList, masterList);
            }
        }
    }

    class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList();
            helper(0, res, nums);
            return res;
        }

        public void helper(int start, List<List<Integer>> res, int[] nums) {
            if (start >= nums.length) {
                List<Integer> list = new ArrayList();
                for (Integer i : nums) list.add(i);
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
