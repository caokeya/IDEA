package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。
假设世界由二维矩阵组成，0 表示该区域未感染病毒，而 1 表示该区域已感染病毒。可以在任意 2 个四方向相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。
现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且保证唯一。
你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。
示例 1：
输入: grid = 
[[0,1,0,0,0,0,0,1],
 [0,1,0,0,0,0,0,1],
 [0,0,0,0,0,0,0,1],
 [0,0,0,0,0,0,0,0]]
输出: 10
说明:
一共有两块被病毒感染的区域: 从左往右第一块需要 5 个防火墙，同时若该区域不隔离，晚上将感染 5 个未感染区域（即被威胁的未感染区域个数为 5）;
第二块需要 4 个防火墙，同理被威胁的未感染区域个数是 4。因此，第一天先隔离左边的感染区域，经过一晚后，病毒传播后世界如下:
[[0,1,0,0,0,0,1,1],
 [0,1,0,0,0,0,1,1],
 [0,0,0,0,0,0,1,1],
 [0,0,0,0,0,0,0,1]]
第二题，只剩下一块未隔离的被感染的连续区域，此时需要安装 5 个防火墙，且安装完毕后病毒隔离任务完成。
示例 2：
输入: grid = 
[[1,1,1],
 [1,0,1],
 [1,1,1]]
输出: 4
说明: 
此时只需要安装 4 面防火墙，就有一小区域可以幸存，不被病毒感染。
注意不需要在世界边界建立防火墙。
示例 3:
输入: grid = 
[[1,1,1,0,0,0,0,0,0],
 [1,0,1,0,1,1,1,1,1],
 [1,1,1,0,0,0,0,0,0]]
输出: 13
说明: 
在隔离右边感染区域后，隔离左边病毒区域只需要 2 个防火墙了。
 */
public class _749_Contain_Virus_隔离病毒_难 {
    class Solution {
        public int containVirus(int[][] grid) {
            int[] cost = new int[] { 0 };
            while (check(grid, cost))
                ;
            return cost[0];
        }

        private boolean check(int[][] grid, int[] cost) {
            // update every day information and return false if no improvement can be made
            int count = 1;
            int max = -1;
            boolean flag = false;
            List<int[]> info = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                        int[][] walls = new int[grid.length][grid[0].length];
                        int[] res = new int[2];
                        grid[i][j] = count;
                        dfs(i, j, grid, count, walls, res);
                        if (res[0] != 0)
                            flag = true;
                        if (max == -1 || res[0] > info.get(max)[0]) {
                            max = count - 2;
                        }
                        info.add(res);
                    }
                }
            }
            if (count == 1) {
                return false;
            }
            cost[0] += info.get(max)[1];
            update(grid, max + 2);
            return flag;
        }

        private void dfs(int row, int col, int[][] grid, int count, int[][] walls, int[] res) {
            // dfs and record number of walls need to block this area and how many 0s are
            // under infection
            int[] shiftX = new int[] { 1, 0, -1, 0 };
            int[] shiftY = new int[] { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int newRow = row + shiftX[i];
                int newCol = col + shiftY[i];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                    if (grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = count;
                        dfs(newRow, newCol, grid, count, walls, res);
                    } else if (grid[newRow][newCol] == 0) {
                        if (walls[newRow][newCol] == 0)
                            res[0]++;
                        if ((walls[newRow][newCol] & 1 << i) == 0) {
                            res[1]++;
                            walls[newRow][newCol] |= 1 << i;
                        }
                    }
                }
            }
        }

        private void update(int[][] grid, int quarantine) {
            // set the new infected area and set blocked area to be -1
            int[] shiftX = new int[] { 1, 0, -1, 0 };
            int[] shiftY = new int[] { 0, 1, 0, -1 };

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > 1 && grid[i][j] != quarantine) {
                        for (int k = 0; k < 4; k++) {
                            int newRow = i + shiftX[k];
                            int newCol = j + shiftY[k];
                            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                                    && grid[newRow][newCol] == 0) {
                                grid[newRow][newCol] = 1;
                            }
                        }
                        grid[i][j] = 1;
                    } else if (grid[i][j] == quarantine) {
                        grid[i][j] = -1;
                    }
                }
            }
        }
    }
}
