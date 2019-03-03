package com.Java;

/*
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。
示例:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
返回 13。
 */
public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix_有序矩阵中第K小的元素 {
    public class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int count = getLessEqual(matrix, mid);
                if (count < k)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
            return lo;
        }

        private int getLessEqual(int[][] matrix, int val) {
            int res = 0;
            int n = matrix.length, i = n - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] > val)
                    i--;
                else {
                    res += i + 1;
                    j++;
                }
            }
            return res;
        }
    }
}
