package com.Java;

import java.util.LinkedList;
import java.util.Queue;

/*
给定一个代表游戏板的二维字符矩阵。 
'M' 代表一个未挖出的地雷，
'E' 代表一个未挖出的空方块，
'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
    如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
    如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
    如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
    如果在此次点击中，若无更多方块可被揭露，则返回面板。
示例 1:
输入: 
[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]
Click : [3,0]
输出: 
[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]
示例 2:
输入: 
[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]
Click : [1,2]
输出: 
[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]
 */
/*
如果点击地雷('M')，标记为'X'，停止进一步搜索。
如果点击一个空单元格('E')，取决于我周围有多少个:
已包围矿井，用周围矿井的数量标记，停止进一步搜索。
我的周围没有，标记为“B”，继续搜索它的8个邻居。
 */
public class _529_Minesweeper_扫雷游戏 {
    // DFS
    public class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            int m = board.length, n = board[0].length;
            int row = click[0], col = click[1];

            if (board[row][col] == 'M') { // Mine
                board[row][col] = 'X';
            } else { // Empty
                     // Get number of mines first.
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0)
                            continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
                            continue;
                        if (board[r][c] == 'M' || board[r][c] == 'X')
                            count++;
                    }
                }

                if (count > 0) { // If it is not a 'B', stop further DFS.
                    board[row][col] = (char) (count + '0');
                } else { // Continue DFS to adjacent cells.
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0)
                                continue;
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
                                continue;
                            if (board[r][c] == 'E')
                                updateBoard(board, new int[] { r, c });
                        }
                    }
                }
            }

            return board;
        }
    }

    // BFS
    public class Solution2 {
        public char[][] updateBoard(char[][] board, int[] click) {
            int m = board.length, n = board[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(click);

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                if (board[row][col] == 'M') { // Mine
                    board[row][col] = 'X';
                } else { // Empty
                         // Get number of mines first.
                    int count = 0;
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0)
                                continue;
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
                                continue;
                            if (board[r][c] == 'M' || board[r][c] == 'X')
                                count++;
                        }
                    }

                    if (count > 0) { // If it is not a 'B', stop further BFS.
                        board[row][col] = (char) (count + '0');
                    } else { // Continue BFS to adjacent cells.
                        board[row][col] = 'B';
                        for (int i = -1; i < 2; i++) {
                            for (int j = -1; j < 2; j++) {
                                if (i == 0 && j == 0)
                                    continue;
                                int r = row + i, c = col + j;
                                if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
                                    continue;
                                if (board[r][c] == 'E') {
                                    queue.add(new int[] { r, c });
                                    board[r][c] = 'B'; // Avoid to be added again.
                                }
                            }
                        }
                    }
                }
            }

            return board;
        }
    }
}
