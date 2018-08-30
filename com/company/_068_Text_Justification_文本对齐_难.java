package com.company;

import java.util.ArrayList;
import java.util.List;

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
