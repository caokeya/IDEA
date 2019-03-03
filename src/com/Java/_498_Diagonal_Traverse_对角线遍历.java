package com.Java;

/*
给定一个含有 M x N 个元素的矩阵（M行，N列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
示例:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出:  [1,2,4,7,5,3,6,8,9]
 */
public class _498_Diagonal_Traverse_对角线遍历 {
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0)
                return new int[0];
            int m = matrix.length;
            int n = matrix[0].length;
            int[] ans = new int[m * n];
            int r = 0;
            int c = 0;

            for (int i = 0; i < m * n; i++) {
                ans[i] = matrix[r][c];
                if ((r + c) % 2 == 0) { // moveup
                    if (c == n - 1) {
                        r++;
                    } // 在matrix最右排的情况
                    else if (r == 0) {
                        c++;
                    } // 在matrix第一排的情况
                    else {
                        c++;
                        r--;
                    }
                } else { // movedown
                    if (r == m - 1) {
                        c++;
                    } // 在matrix最底排的情况
                    else if (c == 0) {
                        r++;
                    } // 在matrix最左排的情况
                    else {
                        c--;
                        r++;
                    }
                }
            }
            return ans;
        }
    }
}
