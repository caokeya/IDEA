package com.Java;

/*
一条包含字母 A-Z 的消息通过以下的方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。
给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。
同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）
示例 1 :
输入: "*"
输出: 9
解释: 加密的信息可以被解密为: "A", "B", "C", "D", "E", "F", "G", "H", "I".
示例 2 :
输入: "1*"
输出: 9 + 9 = 18（翻译者标注：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）
 */
public class _639_Decode_Ways_ll_解码方法2_难 {
    class Solution {
        public int numDecodings(String s) {
            long[] dp = new long[s.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                if (i == 0) {
                    dp[i] = 1;
                } else if (i == 1) {
                    if (s.charAt(i - 1) == '0') {
                        dp[i] = 0;
                    } else if (s.charAt(i - 1) == '*') {
                        dp[i] = 9;
                    } else {
                        dp[i] = 1;
                    }
                } else {
                    char first = s.charAt(i - 2);
                    char second = s.charAt(i - 1);

                    if (second == '*') {
                        dp[i] += 9 * dp[i - 1];
                    } else if (second > '0') {
                        dp[i] += dp[i - 1];
                    }

                    if (first == '*') {
                        if (second == '*') {
                            // 11, 12, ..., 19, 21, ..., 26
                            dp[i] += 15 * dp[i - 2];
                        } else {
                            // 1?
                            dp[i] += dp[i - 2];

                            // 2?
                            if (second <= '6') {
                                dp[i] += dp[i - 2];
                            }
                        }
                    } else if (first == '1' || first == '2') {
                        if (second == '*') {
                            if (first == '1') {
                                dp[i] += 9 * dp[i - 2]; // 11, 12, ..., 19
                            } else {
                                dp[i] += 6 * dp[i - 2]; // 21, 22, ..., 26
                            }
                        } else {
                            // Range between 10 ... 26?
                            if (first == '1' || second <= '6') {
                                dp[i] += dp[i - 2];
                            }
                        }
                    }

                    dp[i] %= 1_000_000_007;
                }
            }
            return (int) dp[s.length()];
        }
    }
}
