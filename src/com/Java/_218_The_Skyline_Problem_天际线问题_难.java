package src.com.Java;

import java.util.*;
import java.util.function.Function;

/*
 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。
 现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
 Buildings Skyline Contour
 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。
 可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。
 关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。
 此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
 */
public class _218_The_Skyline_Problem_天际线问题_难 {
    class Solution {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> res = new ArrayList<>();
            List<int[]> height = new ArrayList<>();    // height list to store all buildings' heights
            for (int[] b : buildings) {
                height.add(new int[]{b[0], -b[2]});    // start of a building, height stored as negtive
                height.add(new int[]{b[1], b[2]});     // end of a building, height stored as positive
            }
            Collections.sort(height, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));     // sort the height list
            // a pq that stores all the encountered buildings' heights in descending order
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            pq.offer(0);
            int preMax = 0;
            for (int[] h : height) {
                if (h[1] < 0) {     // h[1] < 0, that means it meets a new building, so add it to pq
                    pq.offer(-h[1]);
                } else {            // h[1] >=0, that means it has reached the end of the building, so remove it from pq
                    pq.remove(h[1]);
                }
                // the current max height in all encountered buildings
                int curMax = pq.peek();
                // if the max height is different from the previous one, that means a critical point is met, add to result list
                if (curMax != preMax) {
                    res.add(new int[]{h[0], curMax});
                    preMax = curMax;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<int[]> getSkyline(int[][] buildings) {
            return helper(buildings, 0, buildings.length - 1);
        }

        private List<int[]> helper(int[][] buildings, int lo, int hi) {
            List<int[]> ret = new ArrayList<>();
            if (lo > hi) {
                return ret;
            } else if (lo == hi) {
                ret.add(new int[]{buildings[lo][0], buildings[lo][2]});
                ret.add(new int[]{buildings[lo][1], 0});
                return ret;
            }
            int mid = lo + (hi - lo) / 2;
            List<int[]> left = helper(buildings, lo, mid);
            List<int[]> right = helper(buildings, mid + 1, hi);
            int li = 0, ri = 0, hl = 0, hr = 0;
            while (li < left.size() || ri < right.size()) {
                long xl = li == left.size() ? Long.MAX_VALUE : left.get(li)[0];
                long xr = ri == right.size() ? Long.MAX_VALUE : right.get(ri)[0];
                if (xl <= xr) {
                    hl = left.get(li)[1];
                    li++;
                }
                if (xl >= xr) {
                    hr = right.get(ri)[1];
                    ri++;
                }
                int x = (int) Math.min(xl, xr);
                int h = Math.max(hl, hr);
                if (ret.isEmpty() || ret.get(ret.size() - 1)[1] != h) {
                    ret.add(new int[]{x, h});
                }
            }
            return ret;
        }
    }
}
