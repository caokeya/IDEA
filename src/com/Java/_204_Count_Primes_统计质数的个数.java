package src.com.Java;

/*
 统计所有小于非负整数 n 的质数的数量。
 示例:
 输入: 10
 输出: 4
 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class _204_Count_Primes_统计质数的个数 {
    class Solution {
        public int countPrimes(int n) {
            if (n < 2)
                return 0;

            boolean[] notPrime = new boolean[n + 1];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (!notPrime[i]) {
                    count++;
                    for (int j = 2; j * i < n; j++) {
                        notPrime[j * i] = true;
                    }
                }
            }
            return count;
        }
    }
}
