package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
示例1:
输入: ["Hello", "Alaska", "Dad", "Peace"]
输出: ["Alaska", "Dad"]
 */
public class _500_Keyboard_Row_键盘行 {
    public class Solution {
        public String[] findWords(String[] words) {
            int[] map = new int[26];
            String[] rows = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
            for (int i = 0; i < rows.length; i++) {
                for (char c : rows[i].toCharArray()) {
                    map[c - 'a'] = i;
                }
            }

            List<String> list = new ArrayList<>();
            for (String word : words) {
                char first = Character.toLowerCase(word.charAt(0));
                for (int i = 1; i <= word.length(); i++) {
                    if (i == word.length()) {
                        list.add(word);
                        break;
                    }
                    char ch = Character.toLowerCase(word.charAt(i));
                    if (map[ch - 'a'] != map[first - 'a']) {
                        break;
                    }
                }
            }
            return list.toArray(new String[list.size()]);
        }
    }
}
