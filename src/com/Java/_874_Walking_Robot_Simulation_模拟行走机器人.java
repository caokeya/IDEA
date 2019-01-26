package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
    -2：向左转 90 度
    -1：向右转 90 度
    1 <= x <= 9：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物。
第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
返回从原点到机器人的最大欧式距离的平方。
示例 1：
输入: commands = [4,-1,3], obstacles = []
输出: 25
解释: 机器人将会到达 (3, 4)
示例 2：
输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
输出: 65
解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 */
public class _874_Walking_Robot_Simulation_模拟行走机器人 {
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            return robotSim1(commands, obstacles);
        }

        public int robotSim1(int[] commands, int[][] obstacles) {
            int[] dx = new int[] { 0, 1, 0, -1 };
            int[] dy = new int[] { 1, 0, -1, 0 };
            int x = 0, y = 0, di = 0;

            // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
            Set<Long> obstacleSet = new HashSet<Long>();
            for (int[] obstacle : obstacles) {
                long ox = (long) obstacle[0] + 30000;
                long oy = (long) obstacle[1] + 30000;
                obstacleSet.add((ox << 16) + oy);
            }

            int ans = 0;
            for (int cmd : commands) {
                if (cmd == -2) // left
                    di = (di + 3) % 4;
                else if (cmd == -1) // right
                    di = (di + 1) % 4;
                else {
                    for (int k = 0; k < cmd; ++k) {
                        int nx = x + dx[di];
                        int ny = y + dy[di];
                        long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                        if (!obstacleSet.contains(code)) {
                            x = nx;
                            y = ny;
                            ans = Math.max(ans, x * x + y * y);
                        }
                    }
                }
            }
            return ans;
        }
    }
}
