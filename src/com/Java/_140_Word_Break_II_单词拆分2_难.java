package src.com.Java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
说明：
    分隔时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。
输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
 */
public class _140_Word_Break_II_单词拆分2_难 {

    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
        }

        // DFS function returns an array including all substrings derived from s.
        List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
            if (map.containsKey(s))
                return map.get(s);

            LinkedList<String> res = new LinkedList<String>();
            if (s.length() == 0) {
                res.add("");
                return res;
            }
            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                    for (String sub : sublist)
                        res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
            map.put(s, res);
            return res;
        }
    }
}
