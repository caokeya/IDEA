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
        /*
        初始数组的顺序不重要，我的第一直觉是对数组排序。
        对于A[i]
        有i个更小的数字,所以有2 ^i个A[i]是最大的序列。
        我们应该做res + =A[i]*(2 ^i)
        有n - i - 1更大的数字,所以有2 ^(n - i - 1)个A[i]是最低的序列。
        我们应该做res - =A[i]* 2 ^(n - i - 1)
        */
        public int sumSubseqWidths(int[] A) {

            int MOD = 1_000_000_007;
            int N = A.length;
            Arrays.sort(A);
            long[] pow2 = new long[N];
            pow2[0] = 1;
            for (int i = 1; i < N; ++i)
                pow2[i] = pow2[i - 1] * 2 % MOD;
            long ans = 0;
            for (int i = 0; i < N; ++i)
                ans = (ans + (pow2[i] - pow2[N - 1 - i]) * A[i]) % MOD;
            return (int) ans;
        }
    }
    class Solution2 {
        public int sumSubseqWidths(int[] A) {
            /*初始数组的顺序不重要，我的第一直觉是对数组排序。
            对于A[i]
            有i个更小的数字,所以有2 ^i个A[i]是最大的序列。
            我们应该做res + =A[i]*(2 ^i)
            有n - i - 1更大的数字,所以有2 ^(n - i - 1)个A[i]是最低的序列。
            我们应该做res - =A[i]* 2 ^(n - i - 1)
            */
            Arrays.sort(A); // 间隔问题必须先sort!!!
            long c = 1, res = 0, mod = (long) 1e9 + 7;
            for (int i = 0; i < A.length; ++i, c = (c << 1) % mod)
                res = (res + A[i] * c - A[A.length - i - 1] * c) % mod;// 第i个和第length-i-1个的幂次数是一样的
            return (int) ((res + mod) % mod);
        }
    }

}
