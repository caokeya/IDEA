package com.Java;

//反转一个数字
/*
给定一个 32 位有符号整数，将整数中的数字进行反转。
示例 1:
输入: 123
输出: 321
 示例 2:
输入: -123
输出: -321
 */
public class _007_Reverse_Integer_反转一个数字 {
	
	class Solution {
		public int reverse(int x) {
			int result = 0;

			while (x != 0) {
				int tail = x % 10;
				int newResult = result * 10 + tail;
				if ((newResult - tail) / 10 != result) {
					return 0;
				}
				result = newResult;
				x = x / 10;
			}
			return result;
		}
	}
	
}
