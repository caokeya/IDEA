package com.Java;

/*
给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
示例 1:
输入: s1 = "sea", s2 = "eat"
输出: 231
解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
在 "eat" 中删除 "t" 并将 116 加入总和。
结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
示例 2:
输入: s1 = "delete", s2 = "leet"
输出: 403
解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 */
public class _712_Minimum_ASCII_Delete_Sum_for_Two_Strings_两个字符串的最小ASCII删除和 {
    /**
     * dp[i][j] = a[i] == b[j] ? dp[i + 1][j + 1] :
     *            min(a[i] + dp[i + 1][j],  // delete a[i] + minimumDeleteSum(a.substr(i+1), b.substr(j))
     *                b[j] + dp[i][j + 1])  // delete b[j] + minimumDeleteSum(a.substr(i), b.substr(j+1))
     */
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int[][] count = new int[s1.length() + 1][s2.length() + 1];
            for (int i = 1; i < count.length; i++) {
                count[i][0] = count[i - 1][0] + s1.charAt(i - 1);
            }
            for (int i = 1; i < count[0].length; i++) {
                count[0][i] = count[0][i - 1] + s2.charAt(i - 1);
            }
            for (int i = 1; i < count.length; i++) {
                for (int j = 1; j < count[0].length; j++) {
                    int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : s1.charAt(i - 1) + s2.charAt(j - 1);
                    count[i][j] = Math.min(count[i - 1][j] + s1.charAt(i - 1), count[i][j - 1] + s2.charAt(j - 1));
                    count[i][j] = Math.min(count[i][j], count[i - 1][j - 1] + cost);
                }
            }
            return count[s1.length()][s2.length()];
        }
    }

}
