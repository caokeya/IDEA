package com.Java;

import java.util.Arrays;

/*
如果一个字符在字符串 S 中有且仅有出现一次，那么我们称其为独特字符。
例如，在字符串 S = "LETTER" 中，"L" 和 "R" 可以被称为独特字符。
我们再定义 UNIQ(S) 作为字符串 S 中独特字符的个数。
那么，在 S = "LETTER" 中， UNIQ("LETTER") =  2。
对于给定字符串 S，计算其所有非空子串的独特字符的个数，即 UNIQ(substring)。
如果出现两个或者多个相同的子串，将其认为是不同的两个子串。
考虑到答案可能会非常大，规定返回格式为：结果 mod 10 ^ 9 + 7。
示例 1:
输入: "ABC"
输出: 10
解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
     其中，每一个子串都由独特字符构成。
     所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
示例 2:
输入: "ABA"
输出: 8
解释: 除了子串 UNIQ('ABA') = 1，其余与示例1相同。
 */
public class _828_Unique_Letter_String_独特字符串_难 {
    class Solution {
        static final int MOD = 1000000007;

        public int uniqueLetterString(String S) {
            // pre stores the prev position of current char,
            // prer stores prev postion of current char before pre
            int[] pre = new int[126], prer = new int[126];
            Arrays.fill(pre, -1);
            Arrays.fill(prer, -1);

            int sum = 0, cur = 0;
            char[] chs = S.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                // cur stores sum of all UNIQ over substring ending at postion i
                cur += (i - pre[chs[i]] - 1) - (pre[chs[i]] - prer[chs[i]]) + 1;
                prer[chs[i]] = pre[chs[i]];
                pre[chs[i]] = i;
                sum += cur;
                sum %= MOD;
            }

            return sum;
        }
    }

    class Solution2 {
        public int uniqueLetterString(String S) {

            int sum = 0;
            int[] contribution = new int[128];
            int[] lastPos = new int[128];
            Arrays.fill(lastPos, -1);
            int cur = 0;
            for (int i = 0; i < S.length(); i++) {

                char c = S.charAt(i);
                cur -= contribution[c];
                contribution[c] = i - lastPos[c];
                cur += contribution[c];
                lastPos[c] = i;
                sum += cur;
            }
            return sum;
        }
    }
}
