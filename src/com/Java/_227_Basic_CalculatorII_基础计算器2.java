package src.com.Java;

import java.util.Stack;

/*
 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 示例 1:
 输入: "3+2*2"
 输出: 7
 示例 2:
 输入: " 3/2 "
 输出: 1
 示例 3:
 输入: " 3+5 / 2 "
 输出: 5
*/
public class _227_Basic_CalculatorII_基础计算器2 {
    public class Solution {
        public int calculate(String s) {
            int len;
            if (s == null || (len = s.length()) == 0) return 0;
            Stack<Integer> stack = new Stack<Integer>();
            int num = 0;
            char sign = '+';
            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                    if (sign == '-') {
                        stack.push(-num);
                    }
                    if (sign == '+') {
                        stack.push(num);
                    }
                    if (sign == '*') {
                        stack.push(stack.pop() * num);
                    }
                    if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    sign = s.charAt(i);
                    num = 0;
                }

            }

            int res = 0;
            for (int i : stack) {
                res += i;
            }
            return res;
        }

    }
}
