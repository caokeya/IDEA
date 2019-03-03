package com.Java;

/*
编写一个函数，其作用是将输入的字符串反转过来。
示例 1:
输入: "hello"
输出: "olleh"
 */
public class _344_Reverse_String_反转字符串 {
    public class Solution {
        public String reverseString(String s) {
            char[] word = s.toCharArray();
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                char temp = word[i];
                word[i] = word[j];
                word[j] = temp;
                i++;
                j--;
            }
            return new String(word);
        }
    }
}
