package src.com.Java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
示例：
输入: [[1,2,2,1],
       [3,1,2],
       [1,3,2],
       [2,4],
       [3,1,2],
       [1,3,1,1]]
输出: 2
 */
public class _554_Brick_Wall_砖墙 {
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            if (wall == null || wall.size() == 0 || wall.get(0).size() == 0) return 0;
            Map<Integer, Integer> myMap = new HashMap<>();
            int maxCross = 0;
            for (int i = 0; i < wall.size(); i++) {
                int cum = 0;
                for (int j = 0; j < wall.get(i).size() - 1; j++) {
                    cum += wall.get(i).get(j);
                    myMap.put(cum, myMap.getOrDefault(cum, 0) + 1);
                    maxCross = Math.max(maxCross, myMap.get(cum));
                }
            }
            return wall.size() - maxCross;
        }
    }
}
