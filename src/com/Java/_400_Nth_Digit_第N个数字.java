package src.com.Java;

/*
在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
注意:
n 是正数且在32为整形范围内 ( n < 231)。
示例 2:
输入:
11
输出:
0
说明:
第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class _400_Nth_Digit_第N个数字 {
    class Solution {
        public int findNthDigit(int n) {
            long base = 9, start = 1;
            int len = 1;

            while (n - base * len > 0) {
                n -= base * len;
                base *= 10;
                start *= 10;
                len++;
            }
            //找到位数
            int index = (n - 1) % len;
            //找到数字，减1是因为start 自己算一个数，要把start 从计算中抠掉
            long num = start + (n - 1) / len;
            for (int i = index; i < len - 1; i++) {
                num /= 10;
            }
            return (int) num % 10;
        }
    }

    class Solution2 {
        public int findNthDigit(int n) {
            int len = 1, start = 1;
            long count = 9;
            while (n > len * count) {
                n -= len * count;
                len++;
                count *= 10;
                start *= 10;
            }
            //找到这个数
            start += (n - 1) / len;
            //转换成字符串
            String str = String.valueOf(start);
            //找到这个字母
            return Character.getNumericValue(str.charAt((n - 1) % len));
        }
    }
}
