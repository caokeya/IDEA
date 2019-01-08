package src.com.Java;

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
            int row = 0;
            int col = 0;

            for (int i = 0; i < m * n; i++) {
                ans[i] = matrix[row][col];
                if ((row + col) % 2 == 0) { // moveup
                    if (col == n - 1) {//最右边，到下一行
                        row++;
                    }
                    else if (row == 0) {//最顶端，向右
                        col++;
                    }
                    else {//向右上
                        col++;
                        row--;
                    }
                } else { // movedown
                    if (row == m - 1) {//最底端，向右
                        col++;
                    }
                    else if (col == 0) {//最左边，向下
                        row++;
                    }
                    else {//向左下
                        col--;
                        row++;
                    }
                }
            }
            return ans;
        }
    }
}
