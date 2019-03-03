package com.Java;
/*
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
示例:
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class _059_Spiral_Matrix_Il_螺旋矩阵2 {
    public class Solution {
        public int[][] generateMatrix(int n) {
            // Declaration
            int[][] matrix = new int[n][n];

            // Edge Case
            if (n == 0) {
                return matrix;
            }

            // Normal Case
            int rowStart = 0;
            int rowEnd = n - 1;
            int colStart = 0;
            int colEnd = n - 1;
            int num = 1; // change

            while (rowStart <= rowEnd && colStart <= colEnd) {
                for (int i = colStart; i <= colEnd; i++) {
                    matrix[rowStart][i] = num++; // change
                }
                rowStart++;

                for (int i = rowStart; i <= rowEnd; i++) {
                    matrix[i][colEnd] = num++; // change
                }
                colEnd--;

                for (int i = colEnd; i >= colStart; i--) {
                    if (rowStart <= rowEnd)
                        matrix[rowEnd][i] = num++; // change
                }
                rowEnd--;

                for (int i = rowEnd; i >= rowStart; i--) {
                    if (colStart <= colEnd)
                        matrix[i][colStart] = num++; // change
                }
                colStart++;
            }

            return matrix;
        }
    }
}
