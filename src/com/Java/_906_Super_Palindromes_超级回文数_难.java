package src.com.Java;

/*
如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
示例：
输入：L = "4", R = "1000"
输出：4
解释：
4，9，121，以及 484 是超级回文数。
注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。
 */
public class _906_Super_Palindromes_超级回文数_难 {
    class Solution {
        public int superpalindromesInRange(String L, String R) {
            int ans = 0;
            long left = (long) Math.ceil(Math.sqrt(Long.parseLong(L)));
            long right = (long) Math.floor(Math.sqrt(Long.parseLong(R)));
            long magic = (long) Math.ceil(Math.pow(10, 4.5));
            for (long i = 1; i <= magic; i++) {
                long even = i, odd = i;
                // Count the even length palindrome
                for (long j = i; j > 0; j = j / 10) {
                    even = even * 10 + (j % 10);
                }
                if (left <= even && even <= right && isPalindrome(even * even))
                    ans++;
                // Count the odd length palindrome
                for (long j = i / 10; j > 0; j = j / 10) {
                    odd = odd * 10 + (j % 10);
                }
                if (left <= odd && odd <= right && isPalindrome(odd * odd))
                    ans++;
            }
            return ans;
        }

        private boolean isPalindrome(long n) {
            if (0 < n && n <= 9)
                return true;
            if (n % 10 == 0)
                return false;
            long m = 0;
            while (n > m) {
                m = m * 10 + n % 10;
                n /= 10;
            }
            return m == n || m / 10 == n;
        }
    }

    class Solution2 {
        public int superpalindromesInRange(String sL, String sR) {
            long L = Long.valueOf(sL);
            long R = Long.valueOf(sR);
            int MAGIC = (int) Math.pow(10, 18 * 0.25);
            int ans = 0;

            // count odd length;
            for (int k = 1; k < MAGIC; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 2; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R)
                    break;
                if (v >= L && isPalindrome(v))
                    ans++;
            }

            // count even length;
            for (int k = 1; k < MAGIC; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 1; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R)
                    break;
                if (v >= L && isPalindrome(v))
                    ans++;
            }

            return ans;
        }

        public boolean isPalindrome(long x) {
            return x == reverse(x);
        }

        public long reverse(long x) {
            long ans = 0;
            while (x > 0) {
                ans = 10 * ans + x % 10;
                x /= 10;
            }

            return ans;
        }
    }
}
