package com.company;

//求一个字符串中最大的子串（字母不重复）

public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() <= 0){
                return 0;
            }
            int j = 0;
            int max = 0;
            int[] map = new int[256];
            for(int i = 0; i < s.length(); i++){
                while(j < s.length() && map[s.charAt(j)] == 0){
                    map[s.charAt(j)] = 1;
                    max = Math.max(max, j - i + 1);
                    j++;
                }
                map[s.charAt(i)] = 0;
            }
            return max;
        }
    }
}

