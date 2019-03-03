package com.Java;

/*
从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
示例:
输入: sx = 1, sy = 1, tx = 3, ty = 5
输出: True
解释:
可以通过以下一系列转换从起点转换到终点：
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)
输入: sx = 1, sy = 1, tx = 2, ty = 2
输出: False
输入: sx = 1, sy = 1, tx = 1, ty = 1
输出: True
 */
public class _780_Reaching_Points_到达终点_难 {
    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (sx < tx && sy < ty)
                if (tx < ty)
                    ty %= tx;
                else
                    tx %= ty;
            return sx == tx && (ty - sy) % sx == 0 || sy == ty && (tx - sx) % sy == 0;
        }
    }

    class Solution2 {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            if (sx == tx && sy == ty) {
                return true;
            } else if (tx == ty || sx > tx || sy > ty) {
                return false;
            } else if (tx > ty) {
                int subtract = Math.max(1, (tx - sx) / ty);
                return reachingPoints(sx, sy, tx - subtract * ty, ty);
            } else {
                int subtract = Math.max(1, (ty - sy) / tx);
                return reachingPoints(sx, sy, tx, ty - subtract * tx);
            }
        }
    }
}
