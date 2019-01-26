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
    /*
    For [3,1,2,4] as example:
    left + 1 = [1,2,1,1]
    right + 1 = [1,3,2,1]
    f = [1,6,2,1]
    res = 3 * 1 + 1 * 6 + 2 * 2 + 4 * 1 = 17
     */
    class Solution {
        public int sumSubarrayMins(int[] A) {
            int res = 0, n = A.length, mod = (int) 1e9 + 7;
            int[] left = new int[n], right = new int[n];
            Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
            for (int i = 0; i < n; ++i) {
                int count = 1;
                while (!s1.isEmpty() && s1.peek()[0] > A[i])// 找到左边比A[i]大的长度
                    count += s1.pop()[1];
                s1.push(new int[]{A[i], count});
                left[i] = count; // 左[i]， A[i]的左大数的长度
            }
            for (int i = n - 1; i >= 0; --i) {
                int count = 1;
                while (!s2.isEmpty() && s2.peek()[0] >= A[i])// 找到右边比A[i]大的长度
                    count += s2.pop()[1];
                s2.push(new int[]{A[i], count});
                right[i] = count; // 右[i]， A[i]的右大数的长度
            }
            for (int i = 0; i < n; ++i)
                res = (res + A[i] * left[i] * right[i]) % mod;
            return res;
        }
    }

    class Solution2 {
        public int sumSubarrayMins(int[] A) {
            int n = A.length;
            int[] front = new int[n], end = new int[n];
            for (int i = 0; i < n; i++) {
                int last = i - 1;
                while (last >= 0 && A[i] < A[last]) // 找到左边比A[i]大的位置
                    last = front[last];
                front[i] = last;
            }
            for (int i = n - 1; i >= 0; i--) {
                int last = i + 1;
                while (last < n && A[i] <= A[last]) // 找到右边比A[i]大的位置
                    last = end[last];
                end[i] = last;
            }
            int res = 0;
            int mod = (int) 1e9 + 7;
            for (int i = 0; i < n; i++) {
                res = (res + A[i] * (end[i] - i) * (i - front[i])) % mod;
            }
            return (int) res;
        }
    }
}
