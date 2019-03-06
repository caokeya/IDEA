package src.com.Java;

/*
给定一个整数，将其转化为7进制，并以字符串形式输出。
示例 1:
输入: 100
输出: "202"
示例 2:
输入: -7
输出: "-10"
 */
public class _504_Base7_7进制 {
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            String sign = num > 0 ? "" : "-";
            num = Math.abs(num);
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                sb.append(num % 7);
                num /= 7;
            }
            return sign + sb.reverse().toString();
        }
    }
}
