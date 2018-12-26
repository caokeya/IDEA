package src.com.Java;

import java.util.Arrays;

/*
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 示例 1:
 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:
 输入: s = "rat", t = "car"
 输出: false
*/
public class _242_Valid_Anagram_有效的字母异位词 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] S = s.toCharArray();
            char[] T = t.toCharArray();
            int[] counter = new int[26];
            for (char c : S) {
                counter[c - 'a']++;
            }
            for (char c : T) {
                if (counter[c - 'a'] < 0) return false;
                counter[c - 'a']--;
            }
            for (int count : counter) {
                if (count != 0) return false;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            char[] arrayS = s.toCharArray();
            char[] arrayT = t.toCharArray();

            Arrays.sort(arrayS);
            Arrays.sort(arrayT);

            return Arrays.equals(arrayS, arrayT);
        }
    }
}
