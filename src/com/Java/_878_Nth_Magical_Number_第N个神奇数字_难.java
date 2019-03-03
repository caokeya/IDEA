package com.Java;

/*
如果正整数可以被 A 或 B 整除，那么它是神奇的。
返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
示例 1：
输入：N = 1, A = 2, B = 3
输出：2
示例 2：
输入：N = 4, A = 2, B = 3
输出：6
示例 3：
输入：N = 5, A = 2, B = 4
输出：10
示例 4：
输入：N = 3, A = 6, B = 4
输出：8
 */
public class _878_Nth_Magical_Number_第N个神奇数字_难 {
    class Solution {
        public int gcd(int x, int y) {
            if (x == 0)
                return y;
            return gcd(y % x, x);// 求出最大公约数
        }

        public int nthMagicalNumber(int N, int A, int B) {
            long low = 0;
            long high = (long) 1e15;

            long L = A / gcd(A, B) * B;// 最小公倍数

            while (low < high) {
                long mid = (low + high) / 2;
                if (mid / A + mid / B - mid / L < N) {// 排除包容原则，得出有多少个可以被整除的数
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return (int) (low % (1_000_000_007));

        }
    }
}
