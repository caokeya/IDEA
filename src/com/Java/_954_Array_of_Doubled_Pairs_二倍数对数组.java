package com.Java;

import java.util.Map;
import java.util.TreeMap;

/*
给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
示例 1：
输入：[3,1,3,6]
输出：false
示例 2：
输入：[2,1,2,6]
输出：false
示例 3：
输入：[4,-2,2,-4]
输出：true
解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
示例 4：
输入：[1,2,4,16,8,4]
输出：false
 */
public class _954_Array_of_Doubled_Pairs_二倍数对数组 {
    /* 
    Count all numbers.
    Loop all numbers on the order of its absolute.
    We have counter[x] of x, so we need the same amount of 2x to match them.
    If c[x] > c[2 * x], then we return false
    If c[x] <= c[2 * x], then we do c[2 * x] -= c[x] to remove matched 2x.
     */
    class Solution {
        public boolean canReorderDoubled(int[] A) {
            Map<Integer, Integer> count = new TreeMap<>();
            for (int a : A)
                count.put(a, count.getOrDefault(a, 0) + 1);
            for (int x : count.keySet()) {
                if (count.get(x) == 0)
                    continue;
                int want = x < 0 ? x / 2 : x * 2;
                if (count.get(x) > count.getOrDefault(want, 0) || x < 0 && x % 2 != 0)
                    return false;
                count.put(want, count.get(want) - count.get(x));
            }
            return true;
        }
    }
}
