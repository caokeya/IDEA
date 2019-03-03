package com.Java;

import java.util.Arrays;

/*
给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。
在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。
返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。
示例 1：
输入：S = "cba", K = 1
输出："acb"
解释：
在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
示例 2：
输入：S = "baaca", K = 3
输出："aaabc"
解释：
在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 */
public class _899_Orderly_Queue_有序队列_难 {
    /*
         * 如果K == 1，我们只能旋转整个字符串。 
         * 如果K > 1，表示我们可以: 旋转整个弦，旋转整个字符串，除了第一个字母。 012345 -> 023451 -> 034512 -> 045123 -> 051234
     */
    class Solution {
        public String orderlyQueue(String S, int K) {
            int n = S.length();
            if (K >= 2) {
                char[] s = S.toCharArray();
                Arrays.sort(s);
                return new String(s);
            } else {
                String ret = S;
                for (int i = 0; i < n; i++) {
                    String T = S.substring(i) + S.substring(0, i);
                    if (T.compareTo(ret) < 0) {
                        ret = T;
                    }
                }
                return ret;
            }
        }
    }
}
