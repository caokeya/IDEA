package com.company;

//计算与垂直线段与X轴所得的最大面积

public class _011_Container_With_Most_Water_计算与垂直线段与X轴所得的最大面积 {

	class Solution {
		public int maxArea(int[] height) {
			int L = height.length, lo = 0, hi = L - 1;
			int max = 0;
			while (lo < hi) {
				int loMax = height[lo], hiMax = height[hi];

				int candidate = (hi - lo) * (loMax < hiMax ? loMax : hiMax);
				max = candidate > max ? candidate : max;

				if (height[lo] <= height[hi])
					while (lo < hi && height[lo] <= loMax)
						++lo;
				else
					while (hi > lo && height[hi] <= hiMax)
						--hi;
			}
			return max;
		}
	}

}
