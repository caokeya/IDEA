package src.com.Java;

import java.util.Stack;

public class _084_Largest_Rectangle_in_Histogram_柱状图中最大的矩形_难 {
    public class Solution {
        public int largestRectangleArea(int[] height) {
            int len = height.length;
            Stack<Integer> s = new Stack<Integer>();
            int maxArea = 0;
            for (int i = 0; i <= len; i++) {
                int h = (i == len ? 0 : height[i]);
                if (s.isEmpty() || h >= height[s.peek()]) {
                    s.push(i);
                } else {
                    int tp = s.pop();
                    maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                    i--;
                }
            }
            return maxArea;
        }
    }
}
