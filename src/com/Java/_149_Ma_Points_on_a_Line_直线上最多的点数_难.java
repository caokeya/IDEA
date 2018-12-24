package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
示例 1:
输入: [[1,1],[2,2],[3,3]]
输出: 3
解释:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
示例 2:
输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出: 4
解释:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
 */
public class _149_Ma_Points_on_a_Line_直线上最多的点数_难 {
    /*
     * Definition for a point.
     */
    public class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /*
     * A line is determined by two factors,say y=ax+b
     * If two points(x1,y1) (x2,y2) are on the same line(Of course).
     * Consider the gap between two points.
     * We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceledsince b is a constant
     * If a third point (x3,y3) are on the same line. So we must have y3=ax3+b
     * Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
     * Since a is a rational, there exists y0 and x0,
     * y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
     * So we can use y0&x0 to track a line;
     */
    public class Solution {
        public int maxPoints(Point[] points) {
            if (points == null)
                return 0;
            if (points.length <= 2)
                return points.length;

            Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
            int result = 0;
            for (int i = 0; i < points.length; i++) {
                map.clear();
                int overlap = 0, max = 0;
                for (int j = i + 1; j < points.length; j++) {
                    int x = points[j].x - points[i].x;
                    int y = points[j].y - points[i].y;
                    if (x == 0 && y == 0) {//相同的点
                        overlap++;
                        continue;
                    }
                    int gcd = generateGCD(x, y);//求最大公约数
                    if (gcd != 0) {
                        x /= gcd;
                        y /= gcd;
                    }

                    if (map.containsKey(x)) {
                        if (map.get(x).containsKey(y)) {
                            map.get(x).put(y, map.get(x).get(y) + 1);
                        } else {
                            map.get(x).put(y, 1);
                        }
                    } else {
                        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                        m.put(y, 1);
                        map.put(x, m);
                    }
                    max = Math.max(max, map.get(x).get(y));
                }
                result = Math.max(result, max + overlap + 1);
            }
            return result;

        }

        private int generateGCD(int a, int b) {
            if (b == 0)
                return a;
            else
                return generateGCD(b, a % b);   //最大公约数
        }
    }
}
