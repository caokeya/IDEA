package src.com.Java;

/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
示例 1:
输入: "hello"
输出: "holle"
 */
public class _345_Reverse_Vowels_of_a_String_反转字符串中的元音字母 {
    public class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length() == 0)
                return s;
            String vowels = "aeiouAEIOU";
            char[] chars = s.toCharArray();
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {

                while (start < end && !vowels.contains(chars[start] + "")) {
                    start++;
                }

                while (start < end && !vowels.contains(chars[end] + "")) {
                    end--;
                }

                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }
            return new String(chars);
        }

    }
}
