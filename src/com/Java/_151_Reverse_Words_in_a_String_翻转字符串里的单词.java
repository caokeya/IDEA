package src.com.Java;
/*
给定一个字符串，逐个翻转字符串中的每个单词。
示例:  
输入: "the sky is blue",
输出: "blue is sky the".
说明:
    无空格字符构成一个单词。
    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class _151_Reverse_Words_in_a_String_翻转字符串里的单词 {
    public class Solution {
        public String reverseWords(String s) {
            String arr[] = s.split(" ");
            if (arr.length == 0) {
                return s.trim();
            }
            StringBuilder ret = new StringBuilder(s.length());
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i].equals("") == false) {
                    ret.append(arr[i]);
                    ret.append(" ");
                }
            }
            return ret.toString().trim();
        }
    }
}
