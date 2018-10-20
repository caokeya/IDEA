package src.com.Java;

import java.util.List;

/*
给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
示例 1:
输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]
输出: 
"apple"
示例 2:
输入:
s = "abpcplea", d = ["a","b","c"]
输出: 
"a"
 */
public class _524_Longest_Word_in_Dictionary_through_Deleting_通过删除字母匹配到字典里最长单词 {
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            String longest = "";
            for (String dictWord : d) {
                int i = 0;
                for (char c : s.toCharArray())
                    if (i < dictWord.length() && c == dictWord.charAt(i))
                        i++;

                if (i == dictWord.length() && dictWord.length() >= longest.length())
                    if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                        longest = dictWord;
            }
            return longest;
        }
    }

    class Solution2 {
        public String findLongestWord(String s, List<String> d) {
            String max_str = "";
            for (String str : d) {
                if (str.length() > max_str.length()
                        || (str.length() == max_str.length() && str.compareTo(max_str) < 0)) {
                    if (isSubsequence(str, s)) {
                        max_str = str;
                    }
                }
            }
            return max_str;
        }

        public boolean isSubsequence(String target, String s) {
            int j = 0;
            for (int i = 0; i < s.length() && j < target.length(); i++) {
                if (target.charAt(j) == s.charAt(i)) {
                    j++;
                }
            }
            return j == target.length();
        }
    }
}
