package src.com.Java;
/*
包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
示例 1:
输入:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
输出:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
解释:
对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 */
public class _661_Image_Smoother_图片平滑器 {
    class Solution {
        public int[][] imageSmoother(int[][] M) {
            int nx = M.length;
            int ny = M[0].length;
            int[][] res = new int[nx][ny];
            for (int i = 0; i < nx; i++) {
                for (int j = 0; j < ny; j++) {
                    res[i][j] = smooth(M, i, j);
                }
            }
            return res;
        }

        private int smooth(int[][] M, int x, int y) {
            int nx = M.length;
            int ny = M[0].length;
            int sum = 0;
            int count = 0;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (x + i < 0 ||
                        x + i >= nx ||
                        y + j < 0 ||
                        y + j >= ny) {
                        //one of index is out of bounds
                        continue;
                    }
                    count++;
                    sum += M[x + i][y + j];
                }
            }

            return sum / count;
        }
    }
}
