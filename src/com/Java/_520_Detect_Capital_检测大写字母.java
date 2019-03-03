package com.Java;

/*
给定一个单词，你需要判断单词的大写使用是否正确。
我们定义，在以下情况时，单词的大写用法是正确的：
    全部字母都是大写，比如"USA"。
    单词中所有字母都不是大写，比如"leetcode"。
    如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
否则，我们定义这个单词没有正确使用大写字母。
示例 1:
输入: "USA"
输出: True
示例 2:
输入: "FlaG"
输出: False
 */
public class _520_Detect_Capital_检测大写字母 {
    class Solution {
        public boolean detectCapitalUse(String word) {
            int count = 0;
            for (char c : word.toCharArray()) {
                if ('Z' - c >= 0)
                    count++;
            }
            return (count == 0 || count == word.length()) || (count == 1 && ('Z' - word.charAt(0) >= 0));
        }
    }

    class Solution2 {
        public boolean detectCapitalUse(String word) {

            boolean first = true, second = true, third = true;

            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    second = false;
                    if (i != 0)
                        third = false;
                } else {
                    first = false;
                }
            }
            return first || second || third;
        }
    }
}
