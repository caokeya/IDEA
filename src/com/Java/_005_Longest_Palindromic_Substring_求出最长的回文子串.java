package src.com.Java;

//求出最长的回文子串
/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。
 */
public class _005_Longest_Palindromic_Substring_求出最长的回文子串 {
	
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}