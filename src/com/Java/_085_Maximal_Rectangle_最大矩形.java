package src.com.Java;

import java.util.Arrays;

/*
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
示例:
输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6
 */
public class _085_Maximal_Rectangle_最大矩形 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0)
                return 0;
            int m = matrix.length;
            int n = matrix[0].length;

            int[] left = new int[n];
            int[] right = new int[n];
            int[] height = new int[n];
            int result = 0;
            Arrays.fill(right, n - 1);
            for (int i = 0; i < m; i++) {
                // update height
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1')
                        height[j]++;
                    else
                        height[j] = 0;
                }
                // update left
                int cur_left = 0;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        left[j] = Math.max(left[j], cur_left);
                    } else {
                        left[j] = 0;
                        cur_left = j + 1;
                    }
                }
                // update right
                int cur_right = n - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') {
                        right[j] = Math.min(right[j], cur_right);
                    } else {
                        right[j] = n - 1;
                        cur_right = j - 1;
                    }
                }
                for (int j = 0; j < n; j++) {
                    result = Math.max(result, (right[j] - left[j] + 1) * height[j]);
                }
            }
            return result;
        }
    }
}
