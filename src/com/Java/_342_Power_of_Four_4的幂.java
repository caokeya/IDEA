package src.com.Java;

/*
给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
示例 1:
输入: 16
输出: true
 */
public class _342_Power_of_Four_4的幂 {
    public class Solution {
        public boolean isPowerOfFour(int num) {
            //                            16 -> 1 0000
            //                            32 ->1  0000
            // 0101 0101 0101 0101 0101 0101 0101 0101
            return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
        }
    }

    class Solution2 {
        //The idea is to calculate log4 num and check if its a integer.
        //It can be expanded to check power of any number.
        public boolean isPowerOfFour(int num) {
            if ((Math.log10(num) / Math.log10(4)) % 1 == 0)
                return true;
            else
                return false;
        }
    }
}
