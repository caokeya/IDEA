package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。
示例 1:
rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]
返回 true。5个矩形一起可以精确地覆盖一个矩形区域。
 */
public class _391_Perfect_Rectangle_完美矩形_难 {
    public class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
                return false;
            }

            // x1, y1, x2, y2是最终形成的大矩形的左下角和右上角坐标。
            int x1 = Integer.MAX_VALUE;
            int y1 = Integer.MAX_VALUE;
            int x2 = Integer.MIN_VALUE;
            int y2 = Integer.MIN_VALUE;

            Set<String> set = new HashSet<>();
            int area = 0;

            for (int[] rect : rectangles) {
                x1 = Math.min(rect[0], x1);
                y1 = Math.min(rect[1], y1);
                x2 = Math.max(rect[2], x2);
                y2 = Math.max(rect[3], y2);

                area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

                // s1, s2, s3, s4是当前矩形的4个顶点坐标。
                String s1 = rect[0] + " " + rect[1]; // "x1 y1"
                String s2 = rect[0] + " " + rect[3]; // "x1 y2"
                String s3 = rect[2] + " " + rect[3]; // "x2 y2"
                String s4 = rect[2] + " " + rect[1]; // "x2 y1"

                // 组成最终完整perfect矩形的小矩形们的4个顶点一定是相互重合的
                if (!set.add(s1)) {
                    set.remove(s1);
                }
                if (!set.add(s2)) {
                    set.remove(s2);
                }
                if (!set.add(s3)) {
                    set.remove(s3);
                }
                if (!set.add(s4)) {
                    set.remove(s4);
                }
            }

            if (set.size() != 4 ||
                !set.contains(x1 + " " + y1) ||
                !set.contains(x1 + " " + y2) ||
                !set.contains(x2 + " " + y1) ||
                !set.contains(x2 + " " + y2)) {
                return false;
            }

            return area == (x2 - x1) * (y2 - y1); // 最终完整perfect矩形的面积一定等于所有小矩形们的面积之和。
        }
    }
}
