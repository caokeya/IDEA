package com.Java;

/*
编写一段程序来查找第 n 个超级丑数。
超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
示例:
输入: n = 12, primes = [2,7,13,19]
输出: 32 
解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 */
public class _313_Super_Ugly_Number_超级丑数 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] res = new int[n];
            res[0] = 1;
            int[] index = new int[primes.length];
            for (int i = 1; i < n; i++) {
                res[i] = Integer.MAX_VALUE;
                for (int j = 0; j < primes.length; j++) {
                    res[i] = Math.min(res[i], primes[j] * res[index[j]]);
                }
                //
                for (int j = 0; j < primes.length; j++) {
                    if (primes[j] * res[index[j]] == res[i]) {
                        index[j]++;
                    }
                }
            }
            return res[n - 1];
        }
    }
}
