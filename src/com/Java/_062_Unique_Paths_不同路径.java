package com.Java;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
示例 1:
输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
 */
public class _062_Unique_Paths_不同路径 {
    public class Solution {
        public int uniquePaths(int m, int n) {
            Integer[][] map = new Integer[m][n];
            for (int i = 0; i < m; i++) {
                map[i][0] = 1;
            }
            for (int j = 0; j < n; j++) {
                map[0][j] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
            return map[m - 1][n - 1];
        }
    }
}
