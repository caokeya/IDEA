package com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个整数 n, 返回从 1 到 n 的字典顺序。
例如，
给定 n =13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 */
public class _386_Lexicographical_Numbers_字典序排数 {
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> results = new ArrayList<>();
            if (n <= 0) {
                return results;
            }

            helper(n, results, 1, 9);

            return results;
        }

        private void helper(int n, List<Integer> results, int start, int end) {
            if (start > n) {
                return;
            }
            for (int i = start; i <= end; i++) {
                if (i > n) {
                    return;
                }
                results.add(i);
                helper(n, results, i * 10, i * 10 + 9);
            }
        }
    }
}
