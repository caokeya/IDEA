package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
 */
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
