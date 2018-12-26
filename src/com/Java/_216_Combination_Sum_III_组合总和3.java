package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 说明：
 所有数字都是正整数。
 解集不能包含重复的组合。
 示例 1:
 输入: k = 3, n = 7
 输出: [[1,2,4]]
 示例 2:
 输入: k = 3, n = 9
 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class _216_Combination_Sum_III_组合总和3 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new LinkedList<>();
            dfs(k, n, res, new LinkedList<Integer>(), 1);
            return res;
        }

        private void dfs(int k, int target, List<List<Integer>> res, List<Integer> list, int startval) {
            if (list.size() > k || target < 0) return;
            if (target == 0 && list.size() == k) {
                res.add(new LinkedList<Integer>(list));
                return;
            }
            for (int i = startval; i <= 9; i++) {
                list.add(i);
                dfs(k, target - i, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
