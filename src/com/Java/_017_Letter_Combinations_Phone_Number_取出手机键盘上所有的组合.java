package com.Java;
import java.util.LinkedList;
import java.util.List;

//取出手机键盘上所有的组合
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
public class _017_Letter_Combinations_Phone_Number_取出手机键盘上所有的组合 {

	public static class Solution {

		public List<String> letterCombinations(String digits) {
			LinkedList<String> ans = new LinkedList<String>();
			if (digits.isEmpty())
				return ans;
			String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
			ans.add("");
			for (int i = 0; i < digits.length(); i++) {
				int x = Character.getNumericValue(digits.charAt(i));
				while (ans.peek().length() == i) {
					String t = ans.remove();
					for (char s : mapping[x].toCharArray())
						ans.add(t + s);
				}
			}
			return ans;
		}
	}

}
