package com.Java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
返回 words 中与给定模式匹配的单词列表。
你可以按任何顺序返回答案。
示例：
输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
输出：["mee","aqq"]
解释：
"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
因为 a 和 b 映射到同一个字母。
 */
public class _890_Find_and_Replace_Pattern_查找和替换模式 {
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> result = new LinkedList<>();
            for (String word : words) {
                if (match(word, pattern)) {
                    result.add(word);
                }
            }
            return result;
        }

        private boolean match(String s, String p) {
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                char c2 = p.charAt(i);
                if (!map1.containsKey(c1)) {
                    map1.put(c1, c2);
                }
                if (!map2.containsKey(c2)) {
                    map2.put(c2, c1);
                }
                if (map1.get(c1) != c2 || map2.get(c2) != c1) {
                    return false;
                }
            }
            return true;
        }
    }
}
