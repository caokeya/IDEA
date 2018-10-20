package src.com.Java;

/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
示例 1:
输入:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释: 
长度最长的公共子数组是 [3, 2, 1]。
 */
public class _718_Maximum_Length_of_Repeated_Subarray_最长重复子数组 {
    class Solution {
        public int findLength(int[] A, int[] B) {
            int[][] dp = new int[A.length + 1][B.length + 1];
            int res = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
            return res;
        }
    }
}
