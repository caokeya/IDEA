package com.Java;

//将数字转换为罗马字符
/*
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 */
public class _012_Integer_to_Roman_将数字转换为罗马字符 {

	class Solution {
		public String intToRoman(int num) {
			int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
			String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < values.length; i++) {
				while (num >= values[i]) {
					num -= values[i];
					sb.append(strs[i]);
				}
			}
			return sb.toString();
		}
	}
	
}
