package src.com.Java;

import java.util.Stack;

/*
根据逆波兰表示法，求表达式的值。
有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
说明：
    整数除法只保留整数部分。
    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：
输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: ((2 + 1) * 3) = 9
示例 2：
输入: ["4", "13", "5", "/", "+"]
输出: 6
解释: (4 + (13 / 5)) = 6
示例 3：
输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
输出: 22
解释:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class _150_Evaluate_Reverse_Polish_Notation_逆波兰表达式求值 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String t : tokens) {
                if (t.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if (t.equals("-")) {
                    stack.push(-stack.pop() + stack.pop());
                } else if (t.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (t.equals("/")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                } else {
                    stack.push(Integer.parseInt(t));
                }
            }
            return stack.pop();
        }
    }

    //switch
    class Solution2 {
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
