package src.com.Java;

import java.util.List;
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
public class _120_Triangle_三角形最小路径和 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            // 1-dimensional array dp solution, bottom-up
            int[] dp = new int[triangle.size() + 1];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    }
}
