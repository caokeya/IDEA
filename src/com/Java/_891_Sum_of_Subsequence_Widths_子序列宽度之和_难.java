package src.com.Java;

import java.util.Arrays;

/*
给定一个整数数组 A ，考虑 A 的所有非空子序列。
对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。
返回 A 的所有子序列的宽度之和。
由于答案可能非常大，请返回答案模 10^9+7。
示例：
输入：[2,1,3]
输出：6
解释：
子序列为 [1]，[2]，[3]，[2,1]，[2,3]，[1,3]，[2,1,3] 。
相应的宽度是 0，0，0，1，1，2，2 。
这些宽度之和是 6 。
 */
public class _891_Sum_of_Subsequence_Widths_子序列宽度之和_难 {
    class Solution {
        public int sumSubseqWidths(int[] A) {
            // If it is a subarray problem, the solution is very obviously 2D-DP or Segment Tree.
            // Subsequece的index不连续有skip, DP matrix的index就不能用原来数组的index了, 而要选取target的begin和end values,
            // 2D-DP, dp[min_element][max_element] = count, 即符合min_element和max_element的subsequence的数量, 进行不下去了?!
            // 间隔问题必须先sort!!!
            // For sort(A[i]):
            // There are i smaller numbers,
            // so there are 2 ^ i sequences in which A[i] is maximum.
            // we should do res += A[i] * (2 ^ i)
            // Meanwhile, there are n - i - 1 bigger numbers,
            // so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
            // we should do res -= A[i] * 2 ^ (n - i - 1)
            
            // each A[i] is both the smallest and largest number in somes subsequences
            // when A[i] is the smallest, it needs to be substracted
            // when A[i] is the largest, it needs to be plused
            Arrays.sort(A); // 间隔问题必须先sort!!!
            long c = 1, res = 0, mod = (long) 1e9 + 7;
            for (int i = 0; i < A.length; ++i, c = (c << 1) % mod)
                res = (res + A[i] * c - A[A.length - i - 1] * c) % mod;
            return (int) ((res + mod) % mod);
        }
    }
}
