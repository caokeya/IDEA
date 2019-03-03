package com.Java;

/*
给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
当你将所有盒子都去掉之后，求你能获得的最大积分和。
示例 1：
输入:
[1, 3, 2, 2, 2, 3, 4, 3, 1]
输出:
23
解释:
[1, 3, 2, 2, 2, 3, 4, 3, 1] 
----> [1, 3, 3, 4, 3, 1] (3*3=9 分) 
----> [1, 3, 3, 3, 1] (1*1=1 分) 
----> [1, 1] (3*3=9 分) 
----> [] (2*2=4 分)
 */
public class _546_Remove_Boxes_移除盒子_难 {
    class Solution {
        public int removeBoxes(int[] boxes) {
            int n = boxes.length;
            int[][][] dp = new int[n][n][n];
            return removeBoxesSub(boxes, 0, n - 1, 0, dp);
        }

        private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
            if (i > j)
                return 0;
            if (dp[i][j][k] > 0)
                return dp[i][j][k];

            for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++)
                ; // optimization: all boxes of the same color counted continuously from the first box should be grouped together
            int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);

            for (int m = i + 1; m <= j; m++) {
                if (boxes[i] == boxes[m]) {
                    res = Math.max(res,
                            removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
                }
            }

            dp[i][j][k] = res;
            return res;
        }
    }
}
