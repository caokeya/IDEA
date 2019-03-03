package com.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给出一个含有不重复整数元素的数组，每个整数均大于 1。
我们用这些整数来构建二叉树，每个整数可以使用任意次数。
其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
示例 1:
输入: A = [2, 4]
输出: 3
解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2]
示例 2:
输入: A = [2, 4, 5, 10]
输出: 7
解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 */
public class _823_Binary_Trees_With_Factors_带因子的二叉树 {
    class Solution {
        public int numFactoredBinaryTrees(int[] A) {
            Arrays.sort(A);// 大的可以利用小的结果，先处理小的
            Map<Integer, Integer> valueToIndex = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                valueToIndex.put(A[i], i);
                // A[i] = {2,4,5,10}
                // i = 0,1,2,3
            }
            long result = 0;
            long[] R = new long[A.length];
            for (int i = 0; i < A.length; i++) {
                R[i] = 1;// 每个都是独立的一个bst
                for (int leftIndex = 0; leftIndex < i; leftIndex++) {
                    if (A[leftIndex] > (int) Math.sqrt(A[i])) {
                        break;
                    }
                    if (A[i] % A[leftIndex] == 0) {
                        int rightValue = A[i] / A[leftIndex];
                        if (valueToIndex.containsKey(rightValue)) {
                            int rightIndex = valueToIndex.get(rightValue);
                            if (leftIndex == rightIndex) {
                                R[i] += R[leftIndex] * R[rightIndex];// 两边对称
                            } else {
                                R[i] += R[leftIndex] * R[rightIndex] * 2;// 两边不对称
                            }
                        }
                    }
                }
                result += R[i];
            }
            return (int) (result % ((int) Math.pow(10, 9) + 7));
        }
    }

    class Solution2 {
        public int numFactoredBinaryTrees(int[] A) {
            long res = 0L, mod = (long) Math.pow(10, 9) + 7;
            Arrays.sort(A);
            HashMap<Integer, Long> dp = new HashMap<>();
            for (int i = 0; i < A.length; ++i) {
                dp.put(A[i], 1L);
                for (int j = 0; j < i; ++j)
                    if (A[i] % A[j] == 0 && dp.containsKey(A[i] / A[j]))
                        dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i] / A[j])) % mod);
            }
            for (long v : dp.values())
                res = (res + v) % mod;
            return (int) res;
        }
    }
}
