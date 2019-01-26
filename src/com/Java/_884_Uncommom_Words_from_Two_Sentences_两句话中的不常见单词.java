package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;

/*
给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
返回所有不常用单词的列表。
您可以按任何顺序返回列表。
示例 1：
输入：A = "this apple is sweet", B = "this apple is sour"
输出：["sweet","sour"]
示例 2：
输入：A = "apple apple", B = "banana"
输出：["banana"]
 */
public class _884_Uncommom_Words_from_Two_Sentences_两句话中的不常见单词 {
    class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<String> result = new ArrayList<>();
            String[] a = A.split(" ");
            String[] b = B.split(" ");
            for (int i = 0; i < a.length; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            for (int i = 0; i < b.length; i++) {
                map.put(b[i], map.getOrDefault(b[i], 0) + 1);
            }
            for (String word : map.keySet()) {
                if (map.get(word) == 1) {
                    result.add(word);
                }
            }
            return result.toArray(new String[result.size()]);
        }
    }
}
