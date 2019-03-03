package com.Java;

/*
我们有两个长度相等且不为空的整型数组 A 和 B 。
我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
示例:
输入: A = [1,3,5,4], B = [1,2,3,7]
输出: 1
解释: 
交换 A[3] 和 B[3] 后，两个数组如下:
A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
两个数组均为严格递增的。
 */
public class _801_Minimum_Swaps_To_Make_Sequences_Increasing_使序列递增的最小交换次数 {
    //not_swap[i]是不交换A和B的次数，swap[i]是交换了A和B的次数
    class Solution {
        public int minSwap(int[] A, int[] B) {
            int N = A.length;
            int[] swap = new int[N];
            int[] not_swap = new int[N];
            swap[0] = 1;
            for (int i = 1; i < N; ++i) {
                not_swap[i] = swap[i] = N;
                if (A[i - 1] < A[i] && B[i - 1] < B[i]) {//
                    not_swap[i] = not_swap[i - 1];//i和i-1都不交换
                    swap[i] = swap[i - 1] + 1;//i和i-1都交换
                }
                if (A[i - 1] < B[i] && B[i - 1] < A[i]) {//
                    not_swap[i] = Math.min(not_swap[i], swap[i - 1]);
                    swap[i] = Math.min(swap[i], not_swap[i - 1] + 1);
                }
            }
            return Math.min(swap[N - 1], not_swap[N - 1]);
        }
    }
}
