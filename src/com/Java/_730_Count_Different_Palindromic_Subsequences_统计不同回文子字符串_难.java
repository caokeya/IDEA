package src.com.Java;

/*
给定一个字符串 S，找出 S 中不同的非空回文子字符串个数，并返回该数字与 10^9 + 7 的模。
通过从 S 中删除 0 个或多个字符来获得子字符串。
如果一个字符串字符序列与它的反转字符串字符序列一致，那么它是回文字符串。
如果对于某个 i， A_i != B_i，那么A_1, A_2, ... 和 B_1, B_2, ... 这两个字符串是不同的。
示例1:
输入: 
S = 'bccb'
输出: 6
解释: 
6个不同的非空回文子字符串分别为： 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
注意： 'bcb' 虽然出现两次但仅计数一次。
样例2:
输入: 
S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
输出: 104860361
解释: 
共有 3104860382 个不同的非空回文子字符串，对 10^9 + 7 取模为 104860361。
 */
public class _730_Count_Different_Palindromic_Subsequences_统计不同回文子字符串_难 {
    class Solution {
        public int countPalindromicSubsequences(String S) {
            if (S == null || S.length() == 0) return 0;
            int mod = 1000000007, l, r;
            char[] chars = S.toCharArray();
            int dp[][] = new int[chars.length][chars.length];
            for (int i = chars.length - 1; i > -1; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] != chars[j]) dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]) % mod;
                    else {
                        dp[i][j] = (2 * dp[i + 1][j - 1]) % mod;
                        l = i + 1;
                        r = j - 1;
                        while (l <= r && chars[i] != chars[l])
                            l++;
                        while (l <= r && chars[i] != chars[r])
                            r--;
                        if (l > r)
                            dp[i][j] = (2 + dp[i][j]) % mod;
                        else if (l == r)
                            dp[i][j] = (1 + dp[i][j]) % mod;
                        else if (r - l >= 2)
                            dp[i][j] = (dp[i][j] - dp[l + 1][r - 1]) % mod;
                    }
                    dp[i][j] = (dp[i][j] + mod) % mod;
                }
            }
            return dp[0][chars.length - 1];
        }
    }

    class Solution2 {
        public int countPalindromicSubsequences(String s) {
            int len = s.length();
            int[][] dp = new int[len][len];

            char[] chs = s.toCharArray();
            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;   // Consider the test case "a", "b" "c"...
            }

            for (int distance = 1; distance < len; distance++) {
                for (int i = 0; i < len - distance; i++) {
                    int j = i + distance;
                    if (chs[i] == chs[j]) {
                        int low = i + 1;
                        int high = j - 1;

                        /* Variable low and high here are used to get rid of the duplicate*/

                        while (low <= high && chs[low] != chs[j]) {
                            low++;
                        }
                        while (low <= high && chs[high] != chs[j]) {
                            high--;
                        }
                        if (low > high) {
                            /*
                             * 当left > righ时，说明中间没有和S[i]相同的字母了，就是"aba"这种情况，
                             * 那么就有dp[i][j] = dp[i + 1][j - 1] * 2 + 2，其中dp[i + 1][j - 1]是中间部分的回文子序列个数，
                             * 为啥要乘2呢，因为中间的所有子序列可以单独存在，也可以再外面包裹上字母a，
                             * 所以是成对出现的，要乘2。加2的原因是外层的"a"和"aa"也要统计上。
                             */
                           /*consider the string from i to j is "a...a" "a...a"... where there is no character 'a' inside the leftmost and rightmost 'a'
                             eg:  "aba" while i = 0 and j = 2:  dp[1][1] = 1 records the palindrome{"b"}, 
                             the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"b"}, 
                             and additional time as {"aba"}. The reason why 2 counted is that we also count {"a", "aa"}. 
                             So totally dp[i][j] record the palindrome: {"a", "b", "aa", "aba"}. 
                             */

                            dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                        } else if (low == high) {
                            /*
                             * 当left = right时，说明中间只有一个和S[i]相同的字母，就是"aaa"这种情况，
                             * 那么有dp[i][j] = dp[i + 1][j - 1] * 2 + 1，
                             * 其中乘2的部分跟上面的原因相同，加1的原因是单个字母"a"的情况已经在中间部分算过了，外层就只能再加上个"aa"了。
                             */
                           /*consider the string from i to j is "a...a...a" where there is only one character 'a' inside the leftmost and rightmost 'a'
                             eg:  "aaa" while i = 0 and j = 2: the dp[i + 1][j - 1] records the palindrome {"a"}.  
                             the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"a"}, 
                             and additional time as {"aaa"}. the reason why 1 counted is that 
                             we also count {"aa"} that the first 'a' come from index i and the second come from index j. So totally dp[i][j] records {"a", "aa", "aaa"}
                            */
                            dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                        } else {
                            /*
                             * 当left < right时，说明中间至少有两个和S[i]相同的字母，就是"aabaa"这种情况，
                             * 那么有dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1]，
                             * 其中乘2的部分跟上面的原因相同，要减去left和right中间部分的子序列个数的原因是其被计算了两遍，要将多余的减掉。
                             */
                           /*consider the string from i to j is "a...a...a... a" where there are at least two character 'a' close to leftmost and rightmost 'a'
                              eg: "aacaa" while i = 0 and j = 4: the dp[i + 1][j - 1] records the palindrome {"a",  "c", "aa", "aca"}. 
                              the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"a",  "c", "aa", "aca"}, 
                              and additional time as {"aaa",  "aca", "aaaa", "aacaa"}.  Now there is duplicate :  {"aca"}, 
                              which is removed by deduce dp[low + 1][high - 1]. So totally dp[i][j] record {"a",  "c", "aa", "aca", "aaa", "aaaa", "aacaa"}
                              */
                            dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                        }
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];  //s.charAt(i) != s.charAt(j)
                    }
                    dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
                }
            }

            return dp[0][len - 1];
        }
    }
}
