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
            //convert num to 7进制
            if (num == 0) return "0";
            int res = 0;
            int carry = 1;
            int sign = (num > 0 ? 1 : -1);
            int nums = Math.abs(num);
            while (nums > 0) {
                res += nums % 7 * carry;
                carry *= 10;
                nums /= 7;
            }
            return String.valueOf(res * sign);
        }
    }
}
