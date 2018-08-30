package com.company;

public class _074_Search_a_2D_Matrix_搜索二维矩阵 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0)
                return false;
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0, j = n - 1;
            while (i < m && j >= 0) {
                if (matrix[i][j] == target)
                    return true;
                if (matrix[i][j] > target)
                    j--;
                else
                    i++;
            }
            return false;
        }
    }
}
