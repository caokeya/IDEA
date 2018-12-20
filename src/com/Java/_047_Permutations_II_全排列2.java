package src.com.Java;

import java.util.*;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。
示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class _047_Permutations_II_全排列2 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0)
                return res;
            Arrays.sort(nums);
            helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                list.add(nums[i]);
                helper(res, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
