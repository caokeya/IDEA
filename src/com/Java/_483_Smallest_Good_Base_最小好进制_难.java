package com.Java;

/*
对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
示例 1：
输入："13"
输出："3"
解释：13 的 3 进制是 111。
示例 2：
输入："4681"
输出："8"
解释：4681 的 8 进制是 11111。
示例 3：
输入："1000000000000000000"
输出："999999999999999999"
解释：1000000000000000000 的 999999999999999999 进制是 11。
 */
public class _483_Smallest_Good_Base_最小好进制_难 {
    public class Solution2 {
        public String smallestGoodBase(String n) {
            long num = Long.valueOf(n);

            for (int m = Math.min((int) (Math.pow(num, 0.5)), 64); m > 1; m--) {
                long k = (long) Math.pow(num, 1.0 / m);
                if (isGoodBase(num, k, m))
                    return String.valueOf(k);
            }
            return String.valueOf(num - 1);
        }

        private boolean isGoodBase(long num, long base, int m) {
            long sum = num;
            long val = 1;
            // calculate k^0, k^1, ..., k^m
            for (int i = 0; i <= m; i++) {
                sum -= val;
                val *= base;
            }
            return sum == 0;
        }
    }

    // 其实就是将y写成1+x+x^2+...+x^(n-1)，就是一个等比数列求和，于是我们可以将其转化为y = (x^n - 1)/(x - 1)，
    // 其中x>=2, 3<y<10^18,为了寻找最小的x，我们可以先来确定一下n的取值范围，很明显x越小n越大，所以当x=2时，n最大为log2(y+1)。
    class Solution {
        public String smallestGoodBase1(String n) {
            long num = 0;
            for (char c : n.toCharArray())
                num = num * 10 + c - '0';
            long x = 1;
            for (int p = 64; p >= 1; p--) {
                if ((x << p) < num) {
                    long k = helper(num, p);
                    if (k != -1)
                        return String.valueOf(k);
                }
            }
            return String.valueOf(num - 1);
        }

        private long helper(long num, int p) {
            long l = 1, r = (long) (Math.pow(num, 1.0 / p) + 1);
            while (l < r) {
                long mid = l + (r - l) / 2;
                long sum = 0, cur = 1;
                for (int i = 0; i <= p; i++) {
                    sum += cur;
                    cur *= mid;
                }
                if (sum == num)
                    return mid;
                else if (sum > num)
                    r = mid;
                else
                    l = mid + 1;
            }
            return -1;
        }

    }
}
