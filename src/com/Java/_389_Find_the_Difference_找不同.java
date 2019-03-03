package com.Java;

/*
给定两个字符串 s 和 t，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。
示例:
输入：
s = "abcd"
t = "abcde"
输出：
e
解释：
'e' 是那个被添加的字母。
 */
public class _389_Find_the_Difference_找不同 {
    class Solution {
        public char findTheDifference(String s, String t) {
            char tmp = 0;
            for (char c : s.toCharArray()) {
                tmp ^= c;
            }
            for (char c : t.toCharArray()) {
                tmp ^= c;
            }
            return tmp;
        }
    }

    class Solution2 {
        public char findTheDifference(String s, String t) {
            char[] arrs = s.toCharArray();
            char[] arrt = t.toCharArray();
            int[] charCounts = new int[26];
            int[] charCountt = new int[26];
            for (char ch : arrs) {
                charCounts[ch - 'a']++;
            }
            for (char ch : arrt) {
                charCountt[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (charCountt[i] - charCounts[i] == 1) {
                    return (char) ('a' + i);
                }
            }
            return ' ';
        }
    }
}
