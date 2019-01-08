package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
“最近的”定义为两个整数差的绝对值最小。
示例 1:
输入: "123"
输出: "121"
 */
public class _564_Find_the_Closest_Palindrome_寻找最近的回文数_难 {
    class Solution {
        public String nearestPalindromic(String n) {
            // edge cases, no
            int len = n.length();
            int i = len % 2 == 0 ? len / 2 - 1 : len / 2;
            long left = Long.parseLong(n.substring(0, i + 1));
            // input: n 12345
            List<Long> candidate = new ArrayList<>();
            candidate.add(getPalindrome(left, len % 2 == 0)); // 12321
            candidate.add(getPalindrome(left + 1, len % 2 == 0)); // 12421
            candidate.add(getPalindrome(left - 1, len % 2 == 0)); // 12221
            candidate.add((long) Math.pow(10, len - 1) - 1); // 9999
            candidate.add((long) Math.pow(10, len) + 1); // 100001
            long diff = Long.MAX_VALUE, res = 0, nl = Long.parseLong(n);
            for (long cand : candidate) {
                if (cand == nl)
                    continue;
                if (Math.abs(cand - nl) < diff) {
                    diff = Math.abs(cand - nl);
                    res = cand;
                } else if (Math.abs(cand - nl) == diff) {
                    res = Math.min(res, cand);
                }
            }
            return String.valueOf(res);
        }

        private long getPalindrome(long left, boolean even) {
            long res = left;
            if (!even)
                left = left / 10;
            while (left > 0) {
                res = res * 10 + left % 10;
                left /= 10;
            }
            return res;
        }
    }

    class Solution2 {
        private long getPalindrome(long num) {
            char[] c = String.valueOf(num).toCharArray();
            for (int i = 0, j = c.length - 1; i < j; ++i, --j) {
                c[j] = c[i];
            }
            return Long.valueOf(new String(c));

        }

        public String nearestPalindromic(String n) {
            long num = Long.valueOf(n);
            int factor = (int) Math.pow(10, n.length() / 2);
            long curP = getPalindrome(num);
            long nextP = getPalindrome(num / factor * factor + factor);
            long preP = getPalindrome(num / factor * factor - 1);

            if (curP > num)
                nextP = Math.min(curP, nextP);
            if (curP < num)
                preP = Math.max(curP, preP);

            return String.valueOf(num - preP <= nextP - num ? preP : nextP);
        }
    }
}
