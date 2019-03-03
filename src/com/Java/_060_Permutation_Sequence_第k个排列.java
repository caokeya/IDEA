package com.Java;

import java.util.ArrayList;
/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
给定 n 和 k，返回第 k 个排列。
说明：
    给定 n 的范围是 [1, 9]。
    给定 k 的范围是[1,  n!]。
示例 1:
输入: n = 3, k = 3
输出: "213"
 */
public class _060_Permutation_Sequence_第k个排列 {
    class Solution {
        public String getPermutation(int n, int k) {
            /*
             * 如果将所有的组合均找出来，然后选第k个，这样复杂度会比较高，因此可以换一种思路。 直接从前到后算每个位置应该填补的数即可。
             */
            // 先初始化n位数存在的全排列种类。此处为了方便理解，从0开始到n位，然后数组下标就表示n位的情况。
            int[] f = new int[n + 1];
            f[0] = 1;

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                f[i] = i * f[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            StringBuilder sb = new StringBuilder();
            k--;// 因为计数是从0开始的
            for (int i = n - 1; i >= 0; i--) {
                int index = k / f[i];
                sb.append(list.get(index));
                k = k - f[i] * index;
                list.remove(index);
            }
            return sb.toString();

        }
    }
}
