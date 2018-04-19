package com.company;

//String转换成Int数

public class StringtoInteger {

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
