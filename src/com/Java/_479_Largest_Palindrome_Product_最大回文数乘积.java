package src.com.Java;

/*
你需要找到由两个 n 位数的乘积组成的最大回文数。
由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
示例:
输入: 2
输出: 987
解释: 99 x 91 = 9009, 9009 % 1337 = 987
说明:
n 的取值范围为 [1,8]。
 */
public class _479_Largest_Palindrome_Product_最大回文数乘积 {
    class Solution {
        public int largestPalindrome(int n) {
            if (n == 1)
                return 9;
            int max = (int) Math.pow(10, n) - 1;
            int min = max / 10;
            for (int i = max; i > min; i--) {
                long num = palindrome(i);
                for (long j = max; j * j >= num; j--) {
                    if (num % j == 0)
                        return (int) (num % 1337);
                }
            }
            return -1;
        }

        public long palindrome(int n) {
            StringBuilder sb = new StringBuilder();
            String rev = sb.append(n).reverse().toString();
            return Long.valueOf(n + rev);
        }
    }
}
