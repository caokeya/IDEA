package com.Java;

/*
给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
在此过程之后，我们得到一些数组 B。
返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
示例 1：
输入：A = [1], K = 0
输出：0
解释：B = [1]
示例 2：
输入：A = [0,10], K = 2
输出：6
解释：B = [2,8]
示例 3：
输入：A = [1,3,6], K = 3
输出：0
解释：B = [3,3,3] 或 B = [4,4,4]
 */
public class _908_Smallest_Range_l_最小差值 {
    class Solution {
        public int smallestRangeI(int[] A, int K) {
            int min = A[0];
            int max = A[0];
            for (int i = 1; i < A.length; i++) {
                if (A[i] < min) {
                    min = A[i];
                }
                if (A[i] > max) {
                    max = A[i];
                }
            }
            if ((max - min) <= 2 * K)
                return 0;
            else
                return (max - min - 2 * K);
        }
    }
}
