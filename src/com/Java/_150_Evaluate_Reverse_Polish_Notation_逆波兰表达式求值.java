package src.com.Java;

import java.util.Stack;

/*
根据逆波兰表示法，求表达式的值。
有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
说明：
    整数除法只保留整数部分。
    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class _150_Evaluate_Reverse_Polish_Notation_逆波兰表达式求值 {
    class Solution {
        public int evalRPN(String[] a) {
            Stack<Integer> stack = new Stack<Integer>();

            for (int i = 0; i < a.length; i++) {
                switch (a[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;

                default:
                    stack.push(Integer.parseInt(a[i]));
                }
            }

            return stack.pop();
        }
    }
}
