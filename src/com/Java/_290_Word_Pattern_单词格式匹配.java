package src.src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:
输入: pattern = "abba", str = "dog dog dog dog"
输出: false
*/
public class _290_Word_Pattern_单词格式匹配 {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            Map<Character, String> map = new HashMap<>();
            String[] words = str.split(" ");
            if (words.length != pattern.length()) {
                return false;
            }
            for (int i = 0; i < words.length; ++i) {
                char c = pattern.charAt(i);
                if (!map.containsKey(c)) {
                    if (map.containsValue(words[i])) {
                        return false;
                    }
                    map.put(c, words[i]);
                } else {
                    if (!map.get(c).equals(words[i])) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean wordPattern(String pattern, String str) {
            if (pattern == null || str == null) return false;
            if (pattern.length() == 0) return false;
            String[] x = str.split(" ");
            if (pattern.length() != x.length) return false;
            HashMap<Character, String> hm = new HashMap<Character, String>();
            HashSet<String> hs = new HashSet<String>();
            int len = pattern.length();
            for (int i = 0; i < len; i++) {
                Character ch = pattern.charAt(i);
                String wd = x[i];
                if (hm.containsKey(ch)) {
                    if (!hm.get(ch).equals(wd)) return false;
                } else {
                    if (hs.contains(wd)) return false;
                    hm.put(ch, wd);
                    hs.add(wd);
                }
            }
            return true;
        }
    }
}
