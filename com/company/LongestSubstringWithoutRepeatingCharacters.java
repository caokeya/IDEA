package com.company;

import java.util.HashMap;

//求一个字符串中最大的子串（字母不重复）

public class LongestSubstringWithoutRepeatingCharacters {

	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        
	        int i = 0;
	        int max = 0;
	        for(int j = 0; j < n; j++) {
	            char key = s.charAt(j);
	            if(map.containsKey(key)) {
	                i = Math.max(map.get(key) + 1, i);
	            }           
	            map.put(key, j);
	            max = Math.max(max, j - i + 1);
	        }
	        return max;
	    }
	}
	
}
