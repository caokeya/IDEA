package src.com.Java;

import java.util.LinkedList;
import java.util.Queue;

/*
在一块 N x N 的板子 board 上，从板的左下角开始，每一行交替方向，按从 1 到 N*N 的数字给方格编号。例如，对于一块 6 x 6 大小的板子，可以编号如下：
36 35 34 33 32 31
25 26 27 28 29 30
24 23 22 21 20 19
13 14 15 16 17 18
12 11 10 09 08 07
01 02 03 04 05 06
从板子的方块 1 开始（总是在最后一行、第一列）出发。
从方块 x 开始，每一次移动都包含以下内容：
    你选择一个目标方块 S，它的编号是 x+1，x+2，x+3，x+4，x+5，或者 x+6，只要这个数字满足 <= N*N。
    如果 S 有一个坡或梯子，你就移动到那个坡或梯子的目的地。否则，你会移动到 S。 
在 r 行 c 列上的方格里有 “坡” 或 “梯子”；如果 board[r][c] != -1，那个坡或梯子的目的地将会是 board[r][c]。
注意，你每次移动最多只能爬过一个坡或梯子一次：就算目的地是另一个坡或梯子的起点，你也不会继续移动。
返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
示例：
输入：[
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
输出：4
解释：
首先，从方格 1 [第 5 行，第 0 列] 开始。
你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过坡到方格 13。
然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
然后你决定移动到方格 36, 游戏结束。
可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
 */
public class _909_Snakes_and_Ladders_爬坡和梯子 {
    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            boolean[] visited = new boolean[n * n + 1];

            for (int move = 0; !queue.isEmpty(); move++) {
                for (int size = queue.size(); size > 0; size--) {
                    int num = queue.poll();
                    // 返回答案
                    if (num == n * n)
                        return move;

                    // 如果访问过
                    if (visited[num])
                        continue;
                    visited[num] = true;

                    // 针对下一步
                    for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                        int next = num + i;
                        int value = getBoardValue(board, next);
                        if (value > 0)
                            next = value;
                        if (!visited[next])
                            queue.offer(next);
                    }

                }
            }
            return -1;
        }

        // 想明白 坐标和值的关系
        private int getBoardValue(int[][] board, int num) {
            int n = board.length;
            int r = (num - 1) / n;
            int x = n - 1 - r;
            int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
            return board[x][y];
        }
    }
}
