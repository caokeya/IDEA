package com.company;

public class _050_Pow_x_n_X的n次幂 {
    class Solution {
        public double myPow(double x, int n) {
            int sign = 1;
            if (x < 0 && n % 2 == 1) {
                sign = -1;
            }
            x = Math.abs(x);
            return sign * Math.exp(n * Math.log(x));
        }
    }
}
