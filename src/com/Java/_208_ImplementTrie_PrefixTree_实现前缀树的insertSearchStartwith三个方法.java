package src.com.Java;

/*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
示例:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
 */
class Trie {
	TrieNode root;
	/**
	 * Initialize your data structure here.
	 */
	public Trie() {
		root = new TrieNode(' ');
	}
	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		TrieNode curTrieNode = root;
		for (char c : word.toCharArray()) {
			if (curTrieNode.chilren[c - 'a'] == null) {
				curTrieNode.chilren[c - 'a'] = new TrieNode(c);
			}
			curTrieNode = curTrieNode.chilren[c - 'a'];
		}
		curTrieNode.isCorrectWord = true;
	}
	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		TrieNode curTrieNode = root;
		for (char c : word.toCharArray()) {
			if (curTrieNode.chilren[c - 'a'] == null) {
				return false;
			}
			curTrieNode = curTrieNode.chilren[c - 'a'];
		}
		return curTrieNode.isCorrectWord;
	}
	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode curTrieNode = root;
		for (char c : prefix.toCharArray()) {
			if (curTrieNode.chilren[c - 'a'] == null) {
				return false;
			}
			curTrieNode = curTrieNode.chilren[c - 'a'];
		}
		return true;
	}
}
class TrieNode {
	char val;
	boolean isCorrectWord;
	TrieNode[] chilren = new TrieNode[26];

	public TrieNode(char c) {
		val = c;
		isCorrectWord = false;
	}
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

