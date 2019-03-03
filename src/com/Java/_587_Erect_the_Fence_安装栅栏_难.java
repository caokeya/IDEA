package com.Java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
在一个二维的花园中，有一些用 (x,y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。
只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
示例 1:
输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
解释:
示例 2:
输入: [[1,2],[2,2],[4,2]]
输出: [[1,2],[2,2],[4,2]]
解释:
即使树都在一条直线上，你也需要先用绳子包围它们。
 */
public class _587_Erect_the_Fence_安装栅栏_难 {
    /**
     * Definition for a point.
     */
    class Point {
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

    class Solution {
        public List<Point> outerTrees(Point[] points) {
            Set<Point> result = new HashSet<>();

            // Find the leftmost point
            Point first = points[0];
            int firstIndex = 0;
            for (int i = 1; i < points.length; i++) {
                if (points[i].x < first.x) {
                    first = points[i];
                    firstIndex = i;
                }
            }
            result.add(first);

            Point cur = first;
            int curIndex = firstIndex;
            do {
                Point next = points[0];
                int nextIndex = 0;
                for (int i = 1; i < points.length; i++) {
                    if (i == curIndex)
                        continue;
                    int cross = crossProductLength(cur, points[i], next);
                    if (nextIndex == curIndex || cross > 0 ||
                    // Handle collinear points
                            (cross == 0 && distance(points[i], cur) > distance(next, cur))) {
                        next = points[i];
                        nextIndex = i;
                    }
                }
                // Handle collinear points
                for (int i = 0; i < points.length; i++) {
                    if (i == curIndex)
                        continue;
                    int cross = crossProductLength(cur, points[i], next);
                    if (cross == 0) {
                        result.add(points[i]);
                    }
                }

                cur = next;
                curIndex = nextIndex;

            } while (curIndex != firstIndex);

            return new ArrayList<Point>(result);
        }

        private int crossProductLength(Point A, Point B, Point C) {
            // Get the vectors' coordinates.
            int BAx = A.x - B.x;
            int BAy = A.y - B.y;
            int BCx = C.x - B.x;
            int BCy = C.y - B.y;

            // Calculate the Z coordinate of the cross product.
            return (BAx * BCy - BAy * BCx);
        }

        private int distance(Point p1, Point p2) {
            return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        }
    }
}
