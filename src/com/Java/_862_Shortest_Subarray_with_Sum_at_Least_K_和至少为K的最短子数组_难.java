package src.com.Java;

import java.util.Deque;
import java.util.LinkedList;

/*
返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
如果没有和至少为 K 的非空子数组，返回 -1 。
示例 1：
输入：A = [1], K = 1
输出：1
示例 2：
输入：A = [1,2], K = 4
输出：-1
示例 3：
输入：A = [2,-1,2], K = 3
输出：3
 */
public class _862_Shortest_Subarray_with_Sum_at_Least_K_和至少为K的最短子数组_难 {
    /*
    先找到preSum大于K的位置，去掉开头，去掉结尾，取最短的长度
     */
    class Solution {
        public int shortestSubarray(int[] A, int K) {
            if (A.length == 0)
                return -1;
            Deque<Integer> deque = new LinkedList<>();
            long[] preSum = new long[A.length + 1];
            for (int i = 0; i < A.length; i++) {
                preSum[i + 1] = preSum[i] + (long) A[i];
            }
            int ans = A.length + 1;
            for (int i = 0; i < preSum.length; i++) {
                while (!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= K) {
                    ans = Math.min(i - deque.pollFirst(), ans);
                }
                // If we take preSum[i] then preSum[deque.peekLast()] cannot satisfy the result
                while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            return ans < A.length + 1 ? ans : -1;
        }
    }
}
