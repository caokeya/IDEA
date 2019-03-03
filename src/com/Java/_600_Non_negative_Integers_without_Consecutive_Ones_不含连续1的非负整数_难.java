package com.Java;

/*
给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。

示例 1:

输入: 5
输出: 5
解释: 
下面是带有相应二进制表示的非负整数<= 5：
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 */
public class _600_Non_negative_Integers_without_Consecutive_Ones_不含连续1的非负整数_难 {
    public class Solution {
        public int findIntegers(int num) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
            int n = sb.length();

            int a[] = new int[n];
            int b[] = new int[n];
            a[0] = b[0] = 1;
            for (int i = 1; i < n; i++) {
                a[i] = a[i - 1] + b[i - 1];
                b[i] = a[i - 1];
            }

            int result = a[n - 1] + b[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1')
                    break;
                if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0')
                    result -= b[i];
            }

            return result;
        }
    }

    class Solution2 {
        public int findIntegers(int num) {
            if (num < 2)
                return num + 1;
            String s = Integer.toBinaryString(num);
            int n = s.length();
            int[] f = new int[n];
            f[0] = 1;
            f[1] = 2;
            for (int i = 2; i < n; i++)
                f[i] = f[i - 1] + f[i - 2];
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    continue;
                res += f[n - 1 - i];
                if (i > 0 && s.charAt(i - 1) == '1')
                    return res;
            }
            return ++res;
        }
    }
}
