package com.Java;
import java.util.Stack;

//判断一串括号是否是合法匹配的
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 :
输入: "()[]{}"
输出: true
 */
public class _020_Valid_Parentheses_判断一串括号是否是合法匹配的 {

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
