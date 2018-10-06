package src.com.Java;

import java.util.Stack;
/*
给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
示例 1:
输入: "bcabc"
输出: "abc"
示例 2:
输入: "cbacdcbc"
输出: "acdb"
 */
public class _316_Remove_Duplicate_Letters_去除重复字母_难 {
    class Solution {
        public String removeDuplicateLetters(String s) {
            int cnt[] = new int[26];// Count for each character
            boolean vis[] = new boolean[26];// will contain if character (i+'a') is present in current result Stack
            for (char c : s.toCharArray()) {
                cnt[c - 'a']++;// count number of occurences of character
            }
            Stack<Character> stk = new Stack<>();
            for (char c : s.toCharArray()) {
                cnt[c - 'a']--;// decrement number of characters remaining in the string to be analysed
                if (vis[c - 'a'])// if character is already present in stack, dont bother
                    continue;
                // if current character is smaller than last character in stack which occurs
                // later in the string again
                // it can be removed and added later e.g stack = bc remaining string abc then a
                // can pop b and then c
                while (!stk.isEmpty() && c < stk.peek() && cnt[stk.peek() - 'a'] != 0) {
                    vis[stk.pop() - 'a'] = false;
                }
                stk.push(c);// add current character and mark it as visited
                vis[c - 'a'] = true;
            }
            StringBuilder str = new StringBuilder();
            while (!stk.isEmpty()) {
                str.insert(0, stk.pop());
            }
            return str.toString();
        }
    }
}
