package src.com.Java;

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
            int res[] = new int[30], i = 0;
            for (char c : S.toCharArray())
                if (c == '(')
                    res[++i] = 0;
                else
                    res[i - 1] += Math.max(res[i--] * 2, 1);
            return res[0];
        }
    }

    class Solution2 {
        public int scoreOfParentheses(String S) {
            int result = 0, layers = 0;
            for( int i = 0; i < S.length(); i++ ){
                if( S.charAt(i) == '(' )
                    layers++;
                else
                    layers--;
                if( S.charAt(i) == '(' && S.charAt(i+1) == ')' )
                    result += Math.pow(2, (layers-1) );
            }
            return result;
        }
    }
}
