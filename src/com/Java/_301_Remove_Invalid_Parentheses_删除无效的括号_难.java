package com.Java;

import java.util.ArrayList;
import java.util.List;

/*
删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
说明: 输入可能包含了除 ( 和 ) 以外的字符。
示例 
输入: "(a)())()"
输出: ["(a)()()", "(a())()"]
 */
public class _301_Remove_Invalid_Parentheses_删除无效的括号_难 {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            remove(s, ans, 0, 0, new char[] { '(', ')' });
            return ans;
        }

        public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
            for (int stack = 0, i = last_i; i < s.length(); ++i) {
                if (s.charAt(i) == par[0])
                    stack++;
                if (s.charAt(i) == par[1])
                    stack--;
                if (stack >= 0)
                    continue;
                for (int j = last_j; j <= i; ++j)//start from last_j in case of removing duplicate ones
                    if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))//in case of duplicates
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                return;
            }
            String reversed = new StringBuilder(s).reverse().toString();
            if (par[0] == '(') // finished left to right
                remove(reversed, ans, 0, 0, new char[] { ')', '(' });
            else // finished right to left
                ans.add(reversed);
        }
    }
}
