package src.com.Java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            permute(nums, res, 0);
            return res;
        }

        void permute(int[] nums, List<List<Integer>> res, int pos) {
            if (pos == nums.length - 1) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (int n : nums)
                    tmp.add(n);
                res.add(tmp);
                return;
            }

            Set<Integer> visited = new HashSet<>();
            for (int i = pos; i < nums.length; i++) {
                if (visited.contains(nums[i]))
                    continue;
                visited.add(nums[i]);
                swap(nums, i, pos);
                permute(nums, res, pos + 1);
                swap(nums, i, pos);
            }
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
