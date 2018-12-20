package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
    所有数字（包括目标数）都是正整数。
    解集不能包含重复的组合。 
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */
public class _040_Combination_Sum_II_组合总和2 {
    public class Solution {
        public List<List<Integer>> combinationSum2(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            getResult(result, new ArrayList<Integer>(), nums, target, 0);

            return result;
        }

        private void getResult(List<List<Integer>> result, List<Integer> cur, int nums[], int target, int start) {
            if (target > 0) {
                for (int i = start; i < nums.length && target >= nums[i]; i++) {
                    if (i > start && nums[i] == nums[i - 1]) continue;//跳过相同的
                    cur.add(nums[i]);
                    getResult(result, cur, nums, target - nums[i], i + 1);//i + 1
                    cur.remove(cur.size() - 1);
                }
            } else if (target == 0) {
                result.add(new ArrayList<Integer>(cur));
            }
        }
    }
}
