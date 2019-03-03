package com.Java;

/*
给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
如果可以构成，返回 true ；否则返回 false。
(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
注意：
你可以假设两个字符串均只含有小写字母。
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class _383_Ransom_Note_赎金信 {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] res = new int[26];
            char[] r = ransomNote.toCharArray();
            char[] m = magazine.toCharArray();
            if (r.length == 0)
                return true;
            for (char c : r) {
                res[c - 'a']--;
            }
            for (char c : m) {
                res[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (res[i] < 0)
                    return false;
            }
            return true;
        }
    }
}
