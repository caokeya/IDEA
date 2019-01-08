package src.com.Java;

/*
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
示例 1:
s = "abc", t = "ahbgdc"
返回 true.
示例 2:
s = "axc", t = "ahbgdc"
返回 false.
 */
public class _392_Is_Subsequence_判断子序列 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int index = 0;
            for (char c : s.toCharArray()) {
                index = t.indexOf(c, index) + 1;//从index位置开始找c ，找不到的话index = -1 + 1
                if (index == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0)
                return true;
            int indexS = 0, indexT = 0;
            while (indexT < t.length()) {
                if (t.charAt(indexT) == s.charAt(indexS)) {
                    indexS++;
                    if (indexS == s.length())
                        return true;
                }
                indexT++;
            }
            return false;
        }
    }
}
