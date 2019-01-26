package src.com.Java;

import java.util.*;

/*
我们给出了一个（轴对齐的）矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，
其中（x1，y1）是矩形 i 左下角的坐标，（x2，y2）是该矩形右上角的坐标。
找出平面中所有矩形叠加覆盖后的总面积。 由于答案可能太大，请返回它对 10 ^ 9 + 7 取模的结果。
示例 1：
输入：[[0,0,2,2],[1,0,2,3],[1,0,3,1]]
输出：6
示例 2：
输入：[[0,0,1000000000,1000000000]]
输出：49
解释：答案是 10^18 对 (10^9 + 7) 取模的结果， 即 (10^9)^2 → (-7)^2 = 49 。

 */
public class _850_Rectangle_Area_ll_矩形面积2_难 {
    class Solution {
        public int rectangleArea(int[][] rectangles) {

            int mod = (int) Math.pow(10, 9) + 7;
            long res = 0;
            List<int[]> recList = new ArrayList<>();
            for (int[] rec : rectangles)
                addRectangle(recList, rec, 0);
            for (int[] rec : recList)
                res = (res + ((long) (rec[2] - rec[0]) * (long) (rec[3] - rec[1]))) % mod;
            return (int) res % mod;
        }

        // Add new rectangle to the list.
        // In case of overlap break up new rectangle into non-overlapping rectangles.
        // Compare the new rectanlges with the rest of the list.
        public void addRectangle(List<int[]> recList, int[] curRec, int start) {
            if (start >= recList.size()) {
                recList.add(curRec);
                return;
            }
            int[] r = recList.get(start);
            // No overlap
            if (curRec[2] <= r[0] || curRec[3] <= r[1] || curRec[0] >= r[2] || curRec[1] >= r[3]) {
                addRectangle(recList, curRec, start + 1);
                return;
            }
            if (curRec[0] < r[0])
                addRectangle(recList, new int[] { curRec[0], curRec[1], r[0], curRec[3] }, start + 1);
            if (curRec[2] > r[2])
                addRectangle(recList, new int[] { r[2], curRec[1], curRec[2], curRec[3] }, start + 1);
            if (curRec[1] < r[1])
                addRectangle(recList, new int[] { Math.max(r[0], curRec[0]), curRec[1], Math.min(r[2], curRec[2]), r[1] }, start + 1);
            if (curRec[3] > r[3])
                addRectangle(recList, new int[] { Math.max(r[0], curRec[0]), r[3], Math.min(r[2], curRec[2]), curRec[3] }, start + 1);
        }
    }
}
