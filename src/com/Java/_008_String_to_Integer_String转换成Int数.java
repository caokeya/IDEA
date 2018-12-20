package src.com.Java;

/*
实现 atoi，将字符串转为整数。
该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，
选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 */
public class _008_String_to_Integer_String转换成Int数 {
    class Solution {
        public int myAtoi(String str) {
            String current = str.trim();
            if (current.isEmpty()) {
                return 0;
            }
            boolean neg = false;
            if (current.charAt(0) == '-' || current.charAt(0) == '+') {
                if (current.charAt(0) == '-') {
                    neg = true;
                }
                current = current.substring(1);
            }
            long output = 0;
            for (int i = 0; i < current.length(); i++) {
                int num = current.charAt(i) - '0';
                if (num > 9 || num < 0) {
                    break;
                }
                output = output * 10 + num;
                if (output > Integer.MAX_VALUE) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
            if (neg) {
                output *= -1;
            }
            return (int) output;
        }
    }
}
