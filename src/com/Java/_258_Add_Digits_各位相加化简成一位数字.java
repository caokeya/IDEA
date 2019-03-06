package src.src.com.Java;

/*
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
示例:
输入: 38
输出: 2
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。

*/
public class _258_Add_Digits_各位相加化简成一位数字 {
    public class Solution {
        public int addDigits(int num) {
            if (num == 0) {
                return 0;
            }
            if (num % 9 == 0) {
                return 9;
            } else {
                return num % 9;
            }
        }
    }

    class Solution2 {
        public int addDigits(int num) {
            int sum = 0;
            while (num > 0 || sum > 9) {
                if (num == 0) {
                    num = sum;
                    sum = 0;

                }
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }
}
