package src.com.Java;

import java.util.Stack;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class _084_Largest_Rectangle_in_Histogram_柱状图中最大的矩形_难 {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int i;
            Stack<Integer> stack = new Stack<Integer>();
            int area = 0;
            int maxArea = 0;
            for (i = 0; i < heights.length; ) {
                if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                    stack.push(i++);
                } else {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        area = heights[top] * i;
                    } else {
                        area = heights[top] * (i - stack.peek() - 1);
                    }
                    if (maxArea < area)
                        maxArea = area;
                }
            }
            while (!stack.isEmpty()) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peek() - 1);
                }
                if (maxArea < area)
                    maxArea = area;
            }
            return maxArea;
        }
    }
}
