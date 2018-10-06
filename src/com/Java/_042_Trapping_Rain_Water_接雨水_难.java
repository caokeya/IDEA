package src.com.Java;
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
示例:
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */
public class _042_Trapping_Rain_Water_接雨水_难 {
    class Solution {
        public int trap(int[] A) {
            int a = 0;
            int b = A.length - 1;
            int max = 0;
            int leftmax = 0;
            int rightmax = 0;
            while (a <= b) {
                leftmax = Math.max(leftmax, A[a]);
                rightmax = Math.max(rightmax, A[b]);
                if (leftmax < rightmax) {
                    max += (leftmax - A[a]); // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be
                                             // stored
                    a++;
                } else {
                    max += (rightmax - A[b]);
                    b--;
                }
            }
            return max;
        }
    }
}
