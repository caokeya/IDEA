package com.Java;

import java.util.Stack;
/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
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
