package src.com.Java;

/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
示例 1:
输入: "hello"
输出: "holle"
 */
public class _345_Reverse_Vowels_of_a_String_反转字符串中的元音字母 {
    class Solution {
        public String reverseVowels(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            int l = 0;
            int r = s.length() - 1;
            char[] chars = s.toCharArray();
            while (l < r) {
                while (l < r && !isVowel(chars[l])) {
                    l++;
                }
                while (l < r && !isVowel(chars[r])) {
                    r--;
                }
                if (l < r) {
                    char temp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = temp;
                    l++;
                    r--;
                }
            }
            return String.valueOf(chars);
        }

        public boolean isVowel(char c) {
            return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
        }
    }
}
