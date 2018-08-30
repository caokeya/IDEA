package com.company;

//求一个数组里的最大重复字符串

public class _014_Longest_Common_Prefix_求一个数组里的最大重复字符串 {

	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0) {
				return "";
			}
			String prefix = strs[0];
			for (int i = 1; i < strs.length; i++) {
				while (strs[i].indexOf(prefix) != 0) {
					prefix = prefix.substring(0, prefix.length() - 1);
					if (prefix.isEmpty()) {
						return "";
					}
				}
			}
			return prefix;
		}
	}

}
