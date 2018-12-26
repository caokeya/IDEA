package src.com.Java;

/*
根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。
每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
    如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
    如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
    如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
    如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。
下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
示例:
输入:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
 */
public class _289_Game_of_Life_生命游戏 {
    class Solution {
        public void gameOfLife(int[][] board) {
            int[][] neighborsMap = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int neighbors = getLiveNeighbors(board, i, j);
                    neighborsMap[i][j] = neighbors;
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // Rule 4:
                    if (board[i][j] == 0 && neighborsMap[i][j] == 3) {
                        board[i][j] = 1;
                    }

                    // Rule 3:
                    else if (board[i][j] == 1 && neighborsMap[i][j] > 3) {
                        board[i][j] = 0;
                    }

                    // Rule 2:
                    // do nothing

                    // Rule 1:
                    else if (board[i][j] == 1 && neighborsMap[i][j] < 2) {
                        board[i][j] = 0;
                    }
                }
            }
        }

        private int getLiveNeighbors(int[][] board, int row, int col) {
            int liveNeighbors = isLive(board, row - 1, col - 1);
            liveNeighbors += isLive(board, row - 1, col);
            liveNeighbors += isLive(board, row - 1, col + 1);
            liveNeighbors += isLive(board, row, col - 1);
            liveNeighbors += isLive(board, row, col + 1);
            liveNeighbors += isLive(board, row + 1, col - 1);
            liveNeighbors += isLive(board, row + 1, col);
            liveNeighbors += isLive(board, row + 1, col + 1);
            return liveNeighbors;
        }

        private int isLive(int[][] board, int row, int col) {
            if (row < 0 || row >= board.length) {
                return 0;
            }
            if (col < 0 || col >= board[0].length) {
                return 0;
            }
            return board[row][col];
        }
    }
}
