package src.com.Java;

/*
给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class _326_Power_of_Three_3的幂 {
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n < 1) return false;

            while (n % 3 == 0) {
                n /= 3;
            }

            return n == 1;
        }
    }
}
