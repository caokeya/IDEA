package src.com.Java;

/*
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是连续子数组。
 */
public class _152_Maximum_Product_Subarray_乘积最大子序列 {
    class Solution {
        public int maxProduct(int[] A) {
            // store the result that is the max we have found so far
            int r = A[0];
            // imax/imin stores the max/min product of
            // subarray that ends with the current number A[i]
            for (int i = 1, imax = r, imin = r; i < A.length; i++) {
                // multiplied by a negative makes big number smaller, small number bigger
                // so we redefine the extremums by swapping them
                if (A[i] < 0) {
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }
                // max/min product for the current number is either the current number itself
                // or the max/min by the previous number times the current one
                imax = Math.max(A[i], imax * A[i]);
                imin = Math.min(A[i], imin * A[i]);
                // the newly computed max value is a candidate for our global result
                r = Math.max(r, imax);
            }
            return r;
        }
    }
}
