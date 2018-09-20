package src.com.Java;

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
