package src.com.Java;

import java.util.Stack;

/*
 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 示例 1:
 输入: "1 + 1"
 输出: 2
 示例 2:
 输入: " 2-1 + 2 "
 输出: 3
 示例 3:
 输入: "(1+(4+5+2)-3)+(6+8)"
 输出: 23
 */
public class _224_Basic_Calculator_基本计算器_难 {
    class Solution {
        public int calculate(String s) {
            int len = s.length(), sign = 1, result = 0;
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int sum = s.charAt(i) - '0';
                    while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                        sum = sum * 10 + s.charAt(i + 1) - '0';
                        i++;
                    }
                    result += sum * sign;
                } else if (s.charAt(i) == '+')
                    sign = 1;
                else if (s.charAt(i) == '-')
                    sign = -1;
                else if (s.charAt(i) == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (s.charAt(i) == ')') {
                    result = result * stack.pop() + stack.pop();
                }
            }
            return result;
        }
    }
}
