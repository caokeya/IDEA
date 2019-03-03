package com.Java;
/*
给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class _172_Factorial_Trailing_Zeroes_阶乘后的零 {
    public class Solution {
        public int trailingZeroes(int n) {
            int r = 0;
            while (n > 0) {
                n /= 5;
                r += n;
            }
            return r;
        }
    }
}
