package com.Java;

/*
给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
    () 得 1 分。
    AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
    (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
示例 1：
输入： "()"
输出： 1
示例 2：
输入： "(())"
输出： 2
示例 3：
输入： "()()"
输出： 2
示例 4：
输入： "(()(()))"
输出： 6
 */
public class _856_Score_of_Parentheses_括号的分数 {
    class Solution {
        public int scoreOfParentheses(String S) {
            int balance = 0, answer = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '(') {
                    balance++;
                } else {
                    balance--;
                    if (S.charAt(i - 1) == '(') {
                        answer += 1 << balance;
                    }
                }
            }
            return answer;
        }
    }

    class Solution2 {
        public int scoreOfParentheses(String S) {
            if (S.length() == 2)
                return 1;

            int count = 1;
            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(i) == '(')
                    count++;
                else
                    count--;

                if (count == 0 && i == S.length() - 1)
                    return 2 * scoreOfParentheses(S.substring(1, S.length() - 1));
                else if (count == 0)
                    return scoreOfParentheses(S.substring(0, i + 1)) + scoreOfParentheses(S.substring(i + 1));
            }
            return -100;
        }
    }
}
