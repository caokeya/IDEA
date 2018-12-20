package src.com.Java;
import java.util.ArrayList;
import java.util.List;

//写出合法的括号的组合
/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class _022_Generate_Parentheses_写出合法的括号的组合 {
	class Solution {
	    public List<String> generateParenthesis(int n) {
	        List<String> list = new ArrayList<>();
	        if (n > 0) 
	            generate(list, "", n, n);
	        return list;
	    }

	    void generate(List<String> list, String s, int start, int end) {
	        if (start == 0 && end == 0)
	            list.add(s);
	        if (start > 0)
	            generate(list, s + "(", start - 1, end);
	        if (start < end)
	            generate(list, s + ")", start, end - 1);
	    }
	}
}
