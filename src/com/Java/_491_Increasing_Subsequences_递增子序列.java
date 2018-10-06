package src.com.Java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
示例:
输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
public class _491_Increasing_Subsequences_递增子序列 {
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(new ArrayList<Integer>(), 0, nums, res);
            return res;
        }

        public void helper(List<Integer> list, int index, int[] nums, List<List<Integer>> res) {
            if (list.size() > 1)
                res.add(new ArrayList<>(list));
            Set<Integer> used = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if (used.contains(nums[i])) {
                    continue;
                }
                if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                    used.add(nums[i]);
                    list.add(nums[i]);
                    helper(list, i + 1, nums, res);
                    list.remove(list.size() - 1);
                }

            }
        }
    }
}
