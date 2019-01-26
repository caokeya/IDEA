package src.com.Java;

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
}
