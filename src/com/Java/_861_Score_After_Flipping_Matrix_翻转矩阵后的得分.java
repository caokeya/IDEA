package com.Java;

/*
有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
返回尽可能高的分数。
示例：
输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 */
public class _861_Score_After_Flipping_Matrix_翻转矩阵后的得分 {
    class Solution {
        public int matrixScore(int[][] A) {
            int rows = A.length;
            int cols = A[0].length;
            int res = (1 << (cols - 1)) * rows;//计算每行第一个数都是1的时候的值
            for (int i = 1; i < cols; i++) {
                int curr = 0;
                for (int j = 0; j < rows; j++) {
                    curr += A[j][i] == A[j][0] ? 1 : 0;//计算各行1的个数
                }
                res += (Math.max(curr, rows - curr) * (1 << (cols - 1 - i)));
            }
            return res;
        }
    }

    class Solution2 {
        public int matrixScore(int[][] A) {
            // Idea:
            // 1. always make first int 1 instead of 0. (toggle each row first)
            // 2. for each column, decide whether to toggle, by maximising the number of 1s

            // total sum
            int sum = 0;

            // keep track of the number of ones per column
            int[] numOfOnes = new int[A[0].length];

            // first column should always have all '1's
            numOfOnes[0] = A.length;

            // keep track of which row needs flipping
            boolean[] flipRow = new boolean[A.length];

            // Step 1: find out which rows need flipping to get a starting 1
            for (int i = 0; i < A.length; i++) {
                if (A[i][0] == 0) {
                    flipRow[i] = true;
                } else {
                    flipRow[i] = false;
                }
            }

            // Step 2: find out the maximum number of ones per column, and update the array

            // for each column
            for (int i = 1; i < A[0].length; i++) {
                int numZeroes = 0, numOnes = 0;
                // for each int in the column (each row)
                for (int j = 0; j < A.length; j++) {
                    if (A[j][i] == 0) {
                        if (flipRow[j]) {
                            numOnes++;
                        } else {
                            numZeroes++;
                        }
                    }

                    else { // cur int is "1"
                        if (flipRow[j]) {
                            numZeroes++;
                        } else {
                            numOnes++;
                        }
                    }
                }

                if (numZeroes > numOnes) {
                    numOfOnes[i] = numZeroes;
                }

                else {
                    numOfOnes[i] = numOnes;
                }
            }

            // finally, total up the numbers
            int columnValue = 1;
            int rowLength = numOfOnes.length;
            for (int i = 0; i < rowLength; i++) {
                sum += columnValue * numOfOnes[rowLength - 1 - i];

                // multiply column value by 2 as we move leftwards
                columnValue *= 2;
            }

            return sum;
        }
    }
}
