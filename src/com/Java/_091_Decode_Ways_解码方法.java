package com.Java;
/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。
示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class _091_Decode_Ways_解码方法 {
    class Solution {
        public int numDecodings(String s) {
            int len = s.length();
            if (len == 0)
                return 0;
            int[] dp = new int[len + 1];
            dp[len] = 1;
            dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;

            for (int i = len - 2; i >= 0; i--) {
                if (s.charAt(i) == '0')
                    continue;
                else
                    dp[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }

            return dp[0];

        }

    }
}
