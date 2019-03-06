package src.com.Java;

import java.util.ArrayList;
import java.util.List;
/*
给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
文本的最后一行应为左对齐，且单词之间不插入额外的空格。
说明:
    单词是指由非空格字符组成的字符序列。
    每个单词的长度大于 0，小于等于 maxWidth。
    输入单词数组 words 至少包含一个单词。
示例:
输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
 */
public class _068_Text_Justification_文本对齐_难 {
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            int start = 0, end = 1, len = words.length;
            List<String> res = new ArrayList<>();
            while (start < len) {
                int curLen = words[start].length();
                end = start + 1;
                while (end < len && curLen + 1 + words[end].length() <= maxWidth) {
                    curLen += 1 + words[end].length();
                    ++end;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(words[start]);
                if (end == len) {
                    for (int i = start + 1; i < end; ++i) {
                        sb.append(' ');
                        sb.append(words[i]);
                    }
                    while (sb.length() != maxWidth)
                        sb.append(' ');
                } else {
                    int extraSpaces = maxWidth - curLen;
                    int spaces = end - start - 1;
                    if (spaces == 0) {
                        while (sb.length() != maxWidth)
                            sb.append(' ');
                    } else {
                        int eachSpaces = extraSpaces / spaces;
                        int restSpaces = extraSpaces % spaces;
                        for (int i = start + 1; i < end; ++i) {
                            sb.append(' ');
                            for (int j = 0; j < eachSpaces; ++j) {
                                sb.append(' ');
                            }
                            if (restSpaces > 0) {
                                sb.append(' ');
                                --restSpaces;
                            }
                            sb.append(words[i]);
                        }
                    }

                }
                start = end;
                res.add(new String(sb.toString()));
            }
            return res;
        }
    }
}
