package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author suzw
 * @version 创建时间：2018年9月11日 下午3:22:52 类说明
 */
public class _211_Add_and_Search_Word_Data_structure_design_新增和搜索单词_数据结构设计 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary obj = new WordDictionary();
		obj.addWord("apple");
		System.out.println(obj.search("ap.le"));
		
	}

}

/*

*@author: suzw
*@date: 2018年9月11日下午4:47:15
* 方法1： 根据每个word的长度，建立list，将相同长度的word放在同一个list中。 比方法2更快
*/

class WordDictionary {

	Map<Integer, List<String>> map = new HashMap<>();

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		int index = word.length();
		if (!map.containsKey(index)) {
			List<String> list = new ArrayList<>();
			list.add(word);
			map.put(index, list);
		}
		else map.get(index).add(word);
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	if (!map.containsKey(word.length())) {
			return false;
		}
    	
		for (String string : map.get(word.length())) {
			if (isSame(string,word)) {
				return true;
			}
		}
		return false;
    }
    public boolean isSame(String word, String s) {
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i)!='.' && s.charAt(i)!=word.charAt(i)) {
    			return false;
			}
		}
    	return true;
    }
    
}
/*

*@author: suzw
*@date: 2018年9月11日下午4:30:56
*@方法2类似208，使用TrieNode，相对方法1更费时
*/

class WordDictionary2 {

	private TrieNode root;

	class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public String item = "";
	}

	/** Initialize your data structure here. */
	public WordDictionary2() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TrieNode cur = root;
		for (char ch : word.toCharArray()) {
			if (cur.children[ch - 'a'] == null) {
				cur.children[ch - 'a'] = new TrieNode();
			}
			cur = cur.children[ch - 'a'];
		}
		cur.item = word;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

	public boolean match(char[] chars, int pos, TrieNode node) {
		if (pos == chars.length)
			return !node.item.equals("");
		if (chars[pos] != '.') {
			return node.children[chars[pos] - 'a'] != null
					&& match(chars, pos + 1, node.children[chars[pos] - 'a']);
		} else {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null)
					if (match(chars, pos + 1, node.children[i]))
						return true;
			}
		}
		return false;
	}
}
