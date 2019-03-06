package src.com.Java;
/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
示例 1:
输入: dividend = 10, divisor = 3
输出: 3
示例 2:
输入: dividend = 7, divisor = -3
输出: -2
 */
public class _029_Divide_Two_Integers_两数相除 {
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }
            if (divisor == 0) {
                return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
            long a = Math.abs((long) dividend);
            long b = Math.abs((long) divisor);

            int res = 0;
            while (a >= b) {
                int i = 0;
                while (a >= (b << i)) {
                    i++;
                }
                res += (1 << (i - 1));
                a = a - (b << (i - 1));
            }

            return isNeg ? -res : res;
        }
    }
}
