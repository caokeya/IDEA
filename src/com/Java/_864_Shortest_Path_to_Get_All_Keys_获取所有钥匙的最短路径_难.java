package src.com.Java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A", "B", ...）代表锁。
我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。
如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。
换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
示例 1：
输入：["@.a.#",
       "###.#",
       "b.A.B"]
输出：8
示例 2：
输入：["@..aA",
       "..B#.",
       "....b"]
输出：6
 */
public class _864_Shortest_Path_to_Get_All_Keys_获取所有钥匙的最短路径_难 {
    class Solution {
        public int shortestPathAllKeys(String[] grid) {
            int rows = grid.length;
            int cols = grid[0].length();
            int target = 0;

            Queue<Integer> queue = new LinkedList<>();
            boolean[][][] visited = new boolean[rows][cols][64];
            // Initialize
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    char c = grid[i].charAt(j);
                    // 起点位置
                    if (c == '@') {
                        queue.offer((i << 16) | (j << 8));
                        visited[i][j][0] = true;
                    } else if (c >= 'a' && c <= 'f') {
                        // 记录总共有哪些钥匙（最终状态）
                        target |= 1 << c - 'a';
                    }
                }
            }

            int step = 0;
            int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    int x = curr >>> 16;
                    int y = curr >> 8 & 0xFF;
                    int state = curr & 0xFF;
                    if (state == target) {
                        return step;
                    }

                    for (int[] dir : dirs) {
                        int nextX = x + dir[0];
                        int nextY = y + dir[1];
                        int nextState = state;
                        // 超出边界
                        if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) {
                            continue;
                        }
                        char c = grid[nextX].charAt(nextY);
                        // 有障碍物或者不具有当前锁的钥匙
                        if (c == '#' || (c >= 'A' && c <= 'F' && (nextState >> c - 'A' & 1) == 0)) {
                            continue;
                        }
                        // 获得一把钥匙
                        if (c >= 'a' && c <= 'f') {
                            nextState |= 1 << c - 'a';
                        }
                        if (!visited[nextX][nextY][nextState]) {
                            queue.offer((nextX << 16) | (nextY << 8) | nextState);
                            visited[nextX][nextY][nextState] = true;
                        }
                    }
                }
                step++;
            }
            return -1;
        }
    }
}
