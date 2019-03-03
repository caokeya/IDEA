package com.Java;

/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
示例 1:
输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
 */
public class _557_Reverse_Words_in_a_String_III_反转字符串中的单词3 {
    class Solution {
        public String reverseWords(String s) {
            char[] ca = s.toCharArray();
            for (int i = 0; i < ca.length; i++) {
                if (ca[i] != ' ') { // when i is a non-space
                    int j = i;
                    while (j + 1 < ca.length && ca[j + 1] != ' ') {
                        j++;
                    } // move j to the end of the word
                    reverse(ca, i, j);
                    i = j;
                }
            }
            return new String(ca);
        }

        private void reverse(char[] ca, int i, int j) {
            for (; i < j; i++, j--) {
                char tmp = ca[i];
                ca[i] = ca[j];
                ca[j] = tmp;
            }

        }
    }

    public class Solution2 {
        public String reverseWords(String s) {
            String[] str = s.split(" ");
            for (int i = 0; i < str.length; i++)
                str[i] = new StringBuilder(str[i]).reverse().toString();
            StringBuilder result = new StringBuilder();
            for (String st : str)
                result.append(st + " ");
            return result.toString().trim();
        }
    }
}
