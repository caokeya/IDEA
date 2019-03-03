package com.Java;

/*
给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
（请注意，转换不包括向任何方向旋转。）
最大可能的重叠是什么？
示例 1:
输入：A = [[1,1,0],
          [0,1,0],
          [0,1,0]]
     B = [[0,0,0],
          [0,1,1],
          [0,0,1]]
输出：3
解释: 将 A 向右移动一个单位，然后向下移动一个单位。
 */
public class _835_Image_Overlop_图像重叠 {
    class Solution {
        public int largestOverlap(int[][] A, int[][] B) {
            int N = A.length;

            int[][] count = new int[2 * N + 1][2 * N + 1];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] == 1) {
                        for (int m = 0; m < N; m++) {
                            for (int n = 0; n < N; n++) {
                                if (B[m][n] == 1) {
                                    count[i - m + N][j - n + N]++;
                                }
                            }
                        }
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < count.length; i++) {
                for (int j = 0; j < count[0].length; j++) {
                    result = Math.max(result, count[i][j]);
                }
            }
            return result;
        }
    }
}
