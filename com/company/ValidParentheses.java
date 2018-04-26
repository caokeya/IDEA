package com.company;
import java.util.Stack;

//判断一串括号是否是合法匹配的

public class ValidParentheses {

	class Solution {
		public boolean isValid(String s) {
			Stack<Character> stack = new Stack<Character>();
			for (char c : s.toCharArray()) {
				if (c == '(')
					stack.push(')');
				else if (c == '{')
					stack.push('}');
				else if (c == '[')
					stack.push(']');
				else if (stack.isEmpty() || stack.pop() != c)
					return false;
			}
			return stack.isEmpty();
		}
	}

}
