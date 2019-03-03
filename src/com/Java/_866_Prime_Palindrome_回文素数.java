package com.Java;

/*
求出大于或等于 N 的最小回文素数。
回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
例如，2，3，5，7，11 以及 13 是素数。
回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
例如，12321 是回文数。
示例 1：
输入：6
输出：7
示例 2：
输入：8
输出：11
示例 3：
输入：13
输出：101
 */
public class _866_Prime_Palindrome_回文素数 {
    class Solution {
        public int primePalindrome(int N) {
            if (8 <= N && N <= 11)
                return 11;
            for (int x = 1; x < 100000; x++) {
                String s = Integer.toString(x);
                String r = new StringBuilder(s).reverse().toString().substring(1);
                int y = Integer.parseInt(s + r);
                if (y >= N && isPrime(y))
                    return y;
            }
            return -1;
        }

        public Boolean isPrime(int x) {
            if (x < 2 || x % 2 == 0)
                return x == 2;
            for (int i = 3; i * i <= x; i += 2)
                if (x % i == 0)
                    return false;
            return true;
        }
    }

    class Solution2 {
        public int primePalindrome(int N) {
            if (N == 1 || N == 2)
                return 2;
            if (N % 2 == 0)
                N++;
            while (true) {
                if (isPalindrome(N) && isPrime(N))
                    return N;
                N += 2;
                if (10_000_000 < N && N < 100_000_000)
                    N = 100_000_001;
            }
        }

        private boolean isPalindrome(int n) {
            if (n % 10 == 0 && n != 0)
                return false;
            int n1 = 0;
            while (n > n1) {
                n1 = n1 * 10 + (n % 10);
                n /= 10;
            }
            return n1 == n || n == n1 / 10;
        }

        private boolean isPrime(int n) {
            int end = (int) Math.sqrt(n);
            for (int i = 3; i <= end; i += 2) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }
}
