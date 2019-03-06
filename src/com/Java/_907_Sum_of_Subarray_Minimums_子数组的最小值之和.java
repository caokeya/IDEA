package src.com.Java;

import java.util.Stack;

/*
给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
由于答案可能很大，因此返回答案模 10^9 + 7。
示例：
输入：[3,1,2,4]
输出：17
解释：
子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 */
public class _907_Sum_of_Subarray_Minimums_子数组的最小值之和 {
    class Solution {
        public int sumSubarrayMins(int[] A) {
            int MOD = 1000000007;
            int[] smallerLeft = new int[A.length], smallerRight = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                int target = i - 1;
                while (target >= 0 && A[target] > A[i]) {
                    target = smallerLeft[target];
                }
                smallerLeft[i] = target;
            }
            for (int i = A.length - 1; i >= 0; i--) {
                int target = i + 1;
                while (target < A.length && A[target] >= A[i]) {
                    target = smallerRight[target];
                }
                smallerRight[i] = target;
            }

            long res = 0;
            for (int i = 0; i < A.length; i++) {
                res = (res + (A[i] * ((i - smallerLeft[i]) % MOD) * ((smallerRight[i] - i) % MOD)) % MOD) % MOD;
            }

            return (int) res;
        }
    }

    class Solution2 {
        public int sumSubarrayMins(int[] A) {
            int MOD = 1_000_000_007;
            int N = A.length;

            // prev has i* - 1 in increasing order of A[i* - 1]
            // where i* is the answer to query j
            Stack<Integer> stack = new Stack<Integer>();
            int[] prev = new int[N];
            for (int i = 0; i < N; ++i) {
                while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                    stack.pop();
                prev[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            // next has k* + 1 in increasing order of A[k* + 1]
            // where k* is the answer to query j
            stack = new Stack<Integer>();
            int[] next = new int[N];
            for (int k = N - 1; k >= 0; --k) {
                while (!stack.isEmpty() && A[k] < A[stack.peek()])
                    stack.pop();
                next[k] = stack.isEmpty() ? N : stack.peek();
                stack.push(k);
            }

            // Use prev/next array to count answer
            long ans = 0;
            for (int i = 0; i < N; ++i) {
                ans += (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
                ans %= MOD;
            }
            return (int) ans;

        }
    }
}
