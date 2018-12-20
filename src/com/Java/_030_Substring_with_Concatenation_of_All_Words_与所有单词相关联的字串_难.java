package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
示例 1:
输入:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出: [0,9]
解释: 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
 */
public class _030_Substring_with_Concatenation_of_All_Words_与所有单词相关联的字串_难 {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<Integer>();
            if (s == null || s.length() == 0 || words.length == 0 || words == null) {
                return result;
            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            int len = words[0].length();
            for (int j = 0; j < len; j++) {
                HashMap<String, Integer> currMap = new HashMap<String, Integer>();
                int start = j;
                int count = 0;
                for (int i = j; i <= s.length() - len; i = i + len) {
                    String sub = s.substring(i, i + len);
                    if (map.containsKey(sub)) {
                        if (currMap.containsKey(sub)) {
                            currMap.put(sub, currMap.get(sub) + 1);
                        } else {
                            currMap.put(sub, 1);
                        }
                        count++;
                        while (currMap.get(sub) > map.get(sub)) {
                            String left = s.substring(start, start + len);
                            int currCount = currMap.get(left);
                            if (currCount > 1) {
                                currMap.put(left, currCount - 1);
                            } else {
                                currMap.remove(left);
                            }
                            count--;
                            start = start + len;
                        }
                        if (count == words.length) {
                            result.add(start);
                            String left = s.substring(start, start + len);
                            int currCount = currMap.get(left);
                            if (currCount > 1) {
                                currMap.put(left, currCount - 1);
                            } else {
                                currMap.remove(left);
                            }
                            count--;
                            start = start + len;
                        }
                    } else {
                        currMap.clear();
                        start = i + len;
                        count = 0;
                    }

                }
            }
            return result;
        }
    }
}
