package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
我们最多能执行多少次 move 操作？
示例 1：
输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
输出：5
示例 2：
输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
输出：3
示例 3：
输入：stones = [[0,0]]
输出：0
 */
public class _947_Most_Stones_Removed_with_Same_Row_or_Column_移除最多的同行或同列石头 {
    class Solution {

        int islands = 0;
        Map<Integer, Integer> map;

        public int removeStones(int[][] stones) {
            int n = stones.length;
            map = new HashMap<Integer, Integer>();
            for (int[] stone : stones) {
                int x = stone[0], y = stone[1] + 10000; // a stone connect x and y, in order to unify x and y, let y +=
                                                        // 10000

                if (!map.containsKey(x)) {
                    islands++;
                    map.put(x, x);
                }
                if (!map.containsKey(y)) {
                    islands++;
                    map.put(y, y);
                }

                union(x, y);
            }
            return n - islands;
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                map.put(px, py);
                islands--;
            }
        }

        int find(int x) {
            while (x != map.get(x)) {
                x = map.get(x);
                map.put(x, map.get(map.get(x)));
            }
            return x;
        }
    }
}
