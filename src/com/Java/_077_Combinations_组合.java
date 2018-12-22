package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class _077_Combinations_组合 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            backtrack(res, new ArrayList<>(), n, k);
            return res;
        }

        private void backtrack(List<List<Integer>> res, List<Integer> tempList, int n, int remain) {
            if (remain == 0) {
                res.add(new ArrayList<Integer>(tempList));
                return;
            }
            for (int m = n; m > 0; m--) {
                tempList.add(m);
                backtrack(res, tempList, m - 1, remain - 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
