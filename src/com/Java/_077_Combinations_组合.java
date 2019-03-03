package com.Java;

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
    public class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> combs = new ArrayList<List<Integer>>();
            combine(combs, new ArrayList<Integer>(), 1, n, k);
            return combs;
        }

        public void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
            if (k == 0) {
                combs.add(new ArrayList<Integer>(comb));
                return;
            }
            for (int i = start; i <= n; i++) {
                comb.add(i);
                combine(combs, comb, i + 1, n, k - 1);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
