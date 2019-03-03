package com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class _049_Group_Anagrams_字母异位词分组 {
    public class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0)
                return new ArrayList<List<String>>();
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for (String s : strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String keyStr = String.valueOf(ca);
                if (!map.containsKey(keyStr))
                    map.put(keyStr, new ArrayList<String>());
                map.get(keyStr).add(s);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}
