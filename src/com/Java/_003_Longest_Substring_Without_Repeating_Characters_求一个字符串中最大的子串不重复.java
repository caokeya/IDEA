package src.com.Java;

import java.util.HashMap;

//求一个字符串中最大的子串（字母不重复）
/*
给定一个字符串，找出不含有重复字符的最长子串的长度。
示例 1:
输入: "abcabcbb"
输出: 3 
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 无重复字符的最长子串是 "b"，其长度为 1。
 */
public class _003_Longest_Substring_Without_Repeating_Characters_求一个字符串中最大的子串不重复 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();

            int first = 0;
            int max = 0;
            for (int second = 0; second < n; second++) {
                char c = s.charAt(second);
                if (map.containsKey(c)) {
                    first = Math.max(map.get(c) + 1, first);
                }
                map.put(c, second);
                max = Math.max(max, second - first + 1);
            }
            return max;
        }
    }
}
