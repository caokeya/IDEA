package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
说明：
    字母异位词指字母相同，但排列不同的字符串。
    不考虑答案输出的顺序。
示例 1:
输入:
s: "cbaebabacd" p: "abc"
输出:
[0, 6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 */
public class _438_Find_All_Anagrams_in_a_String_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;
        int[] hash = new int[256]; // character hash
        // record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        // two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            // move right everytime, if the character exists in p's hash, 
            // decrease the count current  hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1)
                count--;
            // when the count is down to 0, means we found the right anagram then add window's left to result list
            if (count == 0)
                list.add(left);
            // if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window++ 
            // to reset the hash because we kicked out the left only increase the count if the character is in p
            // the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
                count++;
        }
        return list;
    }
}
