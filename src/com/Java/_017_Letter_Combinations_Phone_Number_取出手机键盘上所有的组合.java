package src.com.Java;
import java.util.LinkedList;
import java.util.List;

//取出手机键盘上所有的组合

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
