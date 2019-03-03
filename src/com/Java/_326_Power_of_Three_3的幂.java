package com.Java;

/*
给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class _326_Power_of_Three_3的幂 {
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0)
                return false;
            if (n == 1)
                return true;
            while (n > 1) {
                if (n % 3 == 0) {
                    n = n / 3;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
