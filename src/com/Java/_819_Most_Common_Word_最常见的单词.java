package src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
题目保证至少有一个词不在禁用列表中，而且答案唯一。
禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
示例：
输入: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
输出: "ball"
解释: 
"hit" 出现了3次，但它是一个禁用的单词。
"ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。 
注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"）， 
"hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 */
public class _819_Most_Common_Word_最常见的单词 {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words)
                map.put(word, map.getOrDefault(word, 0) + 1);
            for (String word : banned)
                if (map.containsKey(word))
                    map.remove(word);
            String res = null;
            for (String word : map.keySet())
                if (res == null || map.get(word) > map.get(res))
                    res = word;
            return res;
        }
    }

    class Solution2 {
        public String mostCommonWord(String paragraph, String[] banned) {
            paragraph += ".";

            Set<String> banset = new HashSet<String>();
            for (String word: banned) banset.add(word);
            Map<String, Integer> count = new HashMap<String, Integer>();

            String ans = "";
            int ansfreq = 0;

            StringBuilder word = new StringBuilder();
            for (char c: paragraph.toCharArray()) {
                if (Character.isLetter(c)) {
                    word.append(Character.toLowerCase(c));
                } else if (word.length() > 0) {
                    String finalword = word.toString();
                    if (!banset.contains(finalword)) {
                        count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                        if (count.get(finalword) > ansfreq) {
                            ans = finalword;
                            ansfreq = count.get(finalword);
                        }
                    }
                    word = new StringBuilder();
                }
            }
            return ans;
        }
    }
}
