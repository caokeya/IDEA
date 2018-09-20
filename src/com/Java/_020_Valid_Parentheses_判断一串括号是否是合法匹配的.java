package src.com.Java;
import java.util.Stack;

//判断一串括号是否是合法匹配的

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
