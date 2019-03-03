package com.Java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
    拆分时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 */
public class _139_Word_Break_单词拆分 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict.size() == 0)
                return false;

            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            Set<String> set = new HashSet<>();
            int maxLength = Integer.MIN_VALUE;
            for (String word : wordDict) {
                maxLength = Math.max(maxLength, word.length());
                set.add(word);
            }

            // recurrence: dp[j] = for i = j-maxLength,..., j-1
            for (int i = 1; i <= s.length(); i++) {
                boolean b = false;
                for (int j = Math.max(0, i - maxLength); j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i)))
                        b = true;
                }
                dp[i] = b;
            }
            return dp[s.length()];
        }
    }
}
