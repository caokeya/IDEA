package com.Java;

/*
统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
请注意，你可以假定字符串里不包括任何不可打印的字符。
示例:
输入: "Hello, my name is John"
输出: 5
 */
public class _434_Number_of_Segments_in_a_String_字符串中的单词数 {
    class Solution {
        public int countSegments(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                    res++;
            return res;
        }

        // Time complexity: O(n)
        // Space complexity: O(1)
    }
}
