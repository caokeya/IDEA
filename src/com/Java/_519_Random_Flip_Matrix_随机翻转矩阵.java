package src.com.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
题中给出一个 n 行 n 列的二维矩阵 (n_rows,n_cols)，且所有值被初始化为 0。要求编写一个 flip 函数，均匀随机的将矩阵中的 0 变为 1，并返回该值的位置下标 [row_id,col_id]；
同样编写一个 reset 函数，将所有的值都重新置为 0。尽量最少调用随机函数 Math.random()，并且优化时间和空间复杂度。
注意:
1.1 <= n_rows, n_cols <= 10000
2. 0 <= row.id < n_rows 并且 0 <= col.id < n_cols
3.当矩阵中没有值为 0 时，不可以调用 flip 函数
4.调用 flip 和 reset 函数的次数加起来不会超过 1000 次
示例 1：
输入: 
["Solution","flip","flip","flip","flip"]
[[2,3],[],[],[],[]]
输出: [null,[0,1],[1,2],[1,0],[1,1]]
示例 2：
输入: 
["Solution","flip","flip","reset","flip"]
[[1,2],[],[],[],[]]
输出: [null,[0,0],[0,1],null,[0,0]]
 */
public class _519_Random_Flip_Matrix_随机翻转矩阵 {
    class Solution {
        Map<Integer, Integer> map;
        int row, col, total;
        Random rand;

        public Solution(int n_rows, int n_cols) {
            map = new HashMap<>();
            rand = new Random();
            row = n_rows;
            col = n_cols;
            reset();
        }

        public int[] flip() {
            int i = rand.nextInt(total--);
            int x = map.getOrDefault(i, i);
            map.put(i, map.getOrDefault(total, total));
            map.put(total, x);
            return new int[] { x / col, x % col };
        }

        public void reset() {
            total = row * col;
        }
    }
}
