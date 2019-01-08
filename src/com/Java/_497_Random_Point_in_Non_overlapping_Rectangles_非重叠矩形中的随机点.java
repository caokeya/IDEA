package src.com.Java;

import java.util.Random;
import java.util.TreeMap;

/*
给定一组不重叠的轴对齐矩形矩形矩形，编写一个随机且一致地在矩形所覆盖的空间中选择一个整数点的函数选择。
注意:
整数点是具有整数坐标的点。
矩形周长上的一点包含在矩形所覆盖的空间中。
第i个矩形= rects[i] = [x1,y1,x2,y2]，其中[x1,y1]是左下角的整数坐标，[x2, y2]是右上角的整数坐标。
每个矩形的长度和宽度不超过2000。
1 < =矩形。长度<= 100 
返回一个点作为一个整数坐标数组[p_x, p_y] 
最多被调用10000次
Example 1:
Input: 
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output: 
[null,[4,1],[4,1],[3,3]]
Example 2:
Input: 
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output: 
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 */
public class _497_Random_Point_in_Non_overlapping_Rectangles_非重叠矩形中的随机点 {
    class Solution {

        TreeMap<Integer, int[]> map;
        Random random;
        int[][] rects;
        int sum = 0;

        public Solution(int[][] rects) {
            this.rects = rects;
            random = new Random();
            map = new TreeMap<>();
            for (int[] rect : rects) {
                int area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                sum += area;
                map.put(sum, rect);
            }
        }

        public int[] pick() {
            int key = map.ceilingKey(random.nextInt(sum + 1));
            return pickPoints(map.get(key));
        }

        public int[] pickPoints(int[] rect) {
            return new int[]{rect[0] + random.nextInt(rect[2] - rect[0] + 1),
                             rect[1] + random.nextInt(rect[3] - rect[1] + 1)};
        }
    }
    /*
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(rects);
     * int[] param_1 = obj.pick();
     */
}
