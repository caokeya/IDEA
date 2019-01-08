package src.com.Java;

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
    class Solution {
        public String smallestGoodBase(String n) {
            long num = Long.parseLong(n);
            long x = 1;
            for (int k = 64; k >= 2; k--) {
                long b = base(num, k);
                if (b != -1)
                    return String.valueOf(b);
            }
            return String.valueOf(num - 1);
        }

        public long base(long num, int k) {
            long lo = 2;
            long hi = (long) Math.pow(num, 1.0 / k) + 1;
            while (lo <= hi) {
                long mid = (hi - lo) / 2 + lo;
                long sum = 1;
                for (int i = 0; i < k; i++) {
                    sum = sum * mid + 1;
                }
                if (sum > num) {
                    hi = mid - 1;
                } else if (sum < num) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
