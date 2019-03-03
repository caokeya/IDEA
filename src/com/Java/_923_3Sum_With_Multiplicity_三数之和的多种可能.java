package com.Java;

/*
给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
示例 1：
输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
输出：20
解释：
按值枚举（A[i]，A[j]，A[k]）：
(1, 2, 5) 出现 8 次；
(1, 3, 4) 出现 8 次；
(2, 2, 4) 出现 2 次；
(2, 3, 3) 出现 2 次。
示例 2：
输入：A = [1,1,2,2,2,2], target = 5
输出：12
解释：
A[i] = 1，A[j] = A[k] = 2 出现 12 次：
我们从 [1,1] 中选择一个 1，有 2 种情况，
从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 */
public class _923_3Sum_With_Multiplicity_三数之和的多种可能 {
    class Solution {
        public int threeSumMulti(int[] A, int target) {
            //
            int mod = 1_000_000_007;
            long res = 0;
            long[] c = new long[101];
            for (int i : A)
                c[i]++;
            for (int i = 0; i <= 100; i++) {
                for (int j = i; j <= 100; j++) {
                    int k = target - i - j;
                    if (k > 100 || k < 0)
                        continue;
                    if (i == j && j == k) {
                        res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                    } else if (i == j && j != k) {
                        res += c[i] * (c[i] - 1) / 2 * c[k];
                    } else if (j < k) {
                        res += c[i] * c[j] * c[k];
                    }
                }
            }
            return (int) (res % mod);
        }
    }
}
