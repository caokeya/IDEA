package src.com.Java;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
public class _125_Valid_Palindrome_判断是不是回文串 {
    class Solution {
        public boolean isPalindrome(String str) {
            String s = str.toLowerCase();
            int i = 0, j = str.length() - 1, len = j;
            while (i < j) {
                while (i <= len
                        && (!(s.charAt(i) >= '0' && s.charAt(i) <= '9') && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')))
                    i++;
                while (j >= 0
                        && (!(s.charAt(j) >= '0' && s.charAt(j) <= '9') && !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')))
                    j--;
                if (i > len || j < 0)
                    break;
                if (s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }
}
