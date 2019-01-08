package src.com.Java;

import java.util.List;

/*
在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
你需要输出替换之后的句子。
示例 1:
输入: dict(词典) = ["cat", "bat", "rat"]
sentence(句子) = "the cattle was rattled by the battery"
输出: "the cat was rat by the bat"
 */
public class _648_Replace_Words_单词替换 {
    class Solution {
        public String replaceWords(List<String> dict, String sentence) {
            if (dict == null || sentence == null)
                return null;

            StringBuilder sb = new StringBuilder();
            String[] arr = sentence.split(" ");
            for (String s : arr) {
                sb.append(replaceWithRootIfExists(dict, s)).append(" ");
            }
            return sb.toString().trim();
        }

        String replaceWithRootIfExists(List<String> dict, String s) {
            String replacedString = s;
            for (String r : dict) {
                if (s.startsWith(r)) {
                    if (replacedString.length() > r.length())
                        replacedString = r;
                }
            }
            return replacedString;
        }
    }
}
