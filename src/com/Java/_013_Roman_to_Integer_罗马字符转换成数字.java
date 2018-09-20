package src.com.Java;

//罗马字符转换成数字

public class _013_Roman_to_Integer_罗马字符转换成数字 {

	class Solution {
		public int romanToInt(String s) {
			int res = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				char c = s.charAt(i);
				switch (c) {
				case 'I':
					res += res >= 5 ? -1 : 1;
					break;
				case 'V':
					res += 5;
					break;
				case 'X':
					res += 10 * (res >= 50 ? -1 : 1);
					// res += res >= 50 ? -10 : 10;
					break;
				case 'L':
					res += 50;
					break;
				case 'C':
					res += 100 * (res >= 500 ? -1 : 1);
					// res += res >= 500 ? -100 : 100;
					break;
				case 'D':
					res += 500;
					break;
				case 'M':
					res += 1000;
					break;
				default:
					break;
				}
			}

			return res;
		}
	}

}
