package com.Java;

import java.util.ArrayList;
import java.util.List;

/*
  给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 */
public class _131_Palindrome_Partitioning_分割回文串 {
    public class Solution {
        List<List<String>> result = new ArrayList<List<String>>();

        public List<List<String>> partition(String s) {
            helper(s, new ArrayList<String>());
            return result;
        }

        public void helper(String s, List<String> cur) { // DFS every combinations
            if (s.length() == 0) {
                result.add(cur);
                return;
            }
            for (int i = 1; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                if (isPal(sub)) {
                    List<String> newList = new ArrayList<String>(cur);
                    newList.add(sub);
                    helper(s.substring(i, s.length()), newList);
                } else
                    continue; // not palindrome, ignore it
            }
        }

        public boolean isPal(String str) {
            int l = 0;
            int r = str.length() - 1;
            while (l <= r) {
                if (str.charAt(l) != str.charAt(r))
                    return false;
                l++;
                r--;
            }
            return true;
        }
    }
}
