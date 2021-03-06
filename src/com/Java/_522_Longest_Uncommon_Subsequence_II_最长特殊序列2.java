package src.com.Java;

/*
给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
示例：
输入: "aba", "cdc", "eae"
输出: 3
 */
public class _522_Longest_Uncommon_Subsequence_II_最长特殊序列2 {
    class Solution {
        public int findLUSlength(String[] strs) {
            int res = -1, n = strs.length;
            for (int i = 0; i < n; i++) {
                if (strs[i].length() < res)
                    continue;
                int j = -1;
                while (++j < n)
                    if (i != j && isSubsequence(strs[i], strs[j]))
                        break;
                if (j == n)
                    res = Math.max(res, strs[i].length());
            }
            return res;
        }

        public boolean isSubsequence(String a, String b) {
            int i = 0, j = 0;
            while (i < a.length() && j < b.length())
                if (a.charAt(i) == b.charAt(j++))
                    i++;
            return i == a.length();
        }
    }
}
