package com.Java;

//String转换成Int数
/*
实现 atoi，将字符串转为整数。
该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，
选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 */
public class _008_String_to_Integer_String转换成Int数 {

	public int myAtoi(String str) {
		int i = 0, sign = 1, r = 0;
		int n = str.length();
		if (n == 0)
			return 0;

		while (i < n && str.charAt(i) == ' ') {
			i++;
		}

		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			sign = str.charAt(i) == '+' ? 1 : -1;
			i++;
		}

		while (i < n) {
			int num = str.charAt(i) - '0';
			if (num < 0 || num > 9)
				break;

			if (r > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE / 10 == r && Integer.MAX_VALUE % 10 < num) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}

			r = 10 * r + num;
			i++;

		}
		return sign * r;
	}

}
