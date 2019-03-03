package com.Java;

/*
给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
示例 1:
输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class _821_Shortest_Distance_to_a_Character_字符的最短距离 {
    class Solution {
        public int[] shortestToChar(String S, char C) {
            int[] rst = new int[S.length()];
            int closestC = Integer.MIN_VALUE / 2;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == C)
                    closestC = i;
                rst[i] = i - closestC;
            }

            closestC = Integer.MAX_VALUE / 2;
            for (int i = S.length() - 1; i >= 0; i--) {
                if (S.charAt(i) == C)
                    closestC = i;
                rst[i] = Math.min(rst[i], closestC - i);
            }
            return rst;
        }
    }
}
