package com.Java;

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回符合要求的最少分割次数。
This can be solved by two points:

    cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
    If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].

The 2nd point reminds us of using dp (caching).

a   b   a   |   c  c
                j  i
       j-1  |  [j, i] is palindrome
   cut(j-1) +  1

 */
public class _132_Palindrome_Partitioning_II_分割回文串2_难 {
    class Solution {
        public int minCut(String str) {
            if (str.length() == 0) {
                return 0;
            }

            int[] cut = new int[str.length()];
            boolean isPal[][] = new boolean[str.length()][str.length()];
            for (int i = 1; i < str.length(); i++) {
                int min = i;
                for (int j = 0; j <= i; j++) {
                    if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
                        isPal[i][j] = true;
                        min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
                    }
                }
                cut[i] = min;
            }
            return cut[str.length() - 1];
        }
    }
}
