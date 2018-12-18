package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 设计一个支持以下两种操作的数据结构：
 void addWord(word)
 bool search(word)
 search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 示例:
 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
public class _211_Add_and_Search_Word_Data_structure_design_新增和搜索单词_数据结构设计 {
	class WordDictionary {
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

		// Adds a word into the data structure.
		public void addWord(String word) {
			int index = word.length();
			if (!map.containsKey(index)) {
				List<String> list = new ArrayList<String>();
				list.add(word);
				map.put(index, list);
			} else {
				map.get(index).add(word);
			}

		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			int index = word.length();
			if (!map.containsKey(index)) {
				return false;
			}
			List<String> list = map.get(index);
			if (isWords(word)) {
				return list.contains(word);
			}
			for (String s : list) {
				if (isSame(s, word)) {
					return true;
				}
			}
			return false;
		}

		boolean isWords(String s) {
			for (int i = 0; i < s.length(); i++) {
				if (!Character.isLetter(s.charAt(i))) {
					return false;
				}
			}
			return true;
		}

		boolean isSame(String a, String search) {
			if (a.length() != search.length()) {
				return false;
			}
			for (int i = 0; i < a.length(); i++) {
				if (search.charAt(i) != '.' && search.charAt(i) != a.charAt(i)) {
					return false;
				}
			}
			return true;
		}
	}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
