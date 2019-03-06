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

        TreeMap<Integer, Integer> map;
        int[][] arrays;
        int sum;
        Random rnd = new Random();

        public Solution(int[][] rects) {
            arrays = rects;
            map = new TreeMap<>();
            sum = 0;

            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
        
                // the right part means the number of points of this rectangle, rather than its area
                // coz ractangles gonna get picked by the num of points
                sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                map.put(sum, i);
            }
        }
    
        public int[] pick() {
            // nextInt(sum) returns a num in [0, sum -1]. After added by 1, it becomes [1, sum]
            int c = map.higherKey(rnd.nextInt(sum));

            return pickInRect(arrays[map.get(c)]);
        }

        private int[] pickInRect(int[] rect) {
            int left = rect[0], right = rect[2], bot = rect[1], top = rect[3];

            return new int[] { left + rnd.nextInt(right - left + 1), bot + rnd.nextInt(top - bot + 1) };
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */


}
