package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，
其中 left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ..., positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。
示例 1:
输入: [[1, 2], [2, 3], [6, 1]]
输出: [2, 5, 5]
解释:
第一个方块 positions[0] = [1, 2] 掉落：
_aa
_aa
-------
方块最大高度为 2 。
第二个方块 positions[1] = [2, 3] 掉落：
__aaa
__aaa
__aaa
_aa__
_aa__
--------------
方块最大高度为5。
大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。
第三个方块 positions[1] = [6, 1] 掉落：
__aaa
__aaa
__aaa
_aa
_aa___a
-------------- 
方块最大高度为5。
因此，我们返回结果[2, 5, 5]。
 */
public class _699_Falling_Squares_掉落的方块_难 {
    /*
             * 这个想法很简单，我们用区间来表示正方形。我们设为矩形的初始高度是pos[1]。这意味着我们假设所有的方块都落到了地上。
             * 我们迭代前面的方块，检查在我的当前方块下面是否有任何方块i。
             * 如果我们发现我们有一个与我们相交的正方形，这意味着我现在的正方形会向上到那个正方形i，我的目标是找到最高的正方形并把正方形的狗放到正方形i上，并设置正方形的高度为
     * cur.height = cur.height + previousMaxHeight;
     */
    class Solution {
        public List<Integer> fallingSquares(int[][] positions) {
            if (positions == null || positions.length == 0) {
                return new ArrayList<Integer>();
            }

            int[] ans = new int[positions.length];
            for (int i = 0; i < positions.length; i++) {
                int left = positions[i][0];
                int size = positions[i][1];
                int right = left + size;
                ans[i] += size;
                for (int j = i + 1; j < positions.length; j++) {
                    int left2 = positions[j][0];
                    int size2 = positions[j][1];
                    int right2 = left2 + size2;
                    if (left2 < right && right2 > left) {
                        ans[j] = Math.max(ans[j], ans[i]);
                    }
                }
            }

            List<Integer> result = new ArrayList<Integer>();
            int current = -1;
            for (int a : ans) {
                current = Math.max(current, a);
                result.add(current);
            }
            return result;
        }
    }
}
