package src.com.Java;

/**
 * 
 */
/**
 * @author suzw
 * @version 创建时间：2018年9月6日 下午3:14:08 类说明 ：Implement a trie with insert, search,
 *          and startsWith methods. Example: Trie trie = new Trie();
 * 
 *          trie.insert("apple"); trie.search("apple"); // returns true
 *          trie.search("app"); // returns false trie.startsWith("app"); //
 *          returns true trie.insert("app"); trie.search("app"); // returns true
 *          Note: You may assume that all inputs are consist of lowercase
 *          letters a-z. All inputs are guaranteed to be non-empty strings.
 */

class Trie {

	public TreeNode root;

	class TreeNode {
		TreeNode[] treeNodes = new TreeNode[26];
		boolean isLeaf = false;
	}

	public Trie() {
		root = new TreeNode();
		// Trie
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TreeNode cur = root;
		for (char ch : word.toCharArray()) {
			if (cur.treeNodes[ch - 'a'] == null) {
				cur.treeNodes[ch - 'a'] = new TreeNode();
			}
			cur = cur.treeNodes[ch - 'a'];
		}
		cur.isLeaf = true;

	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TreeNode cur = root;
		for (char ch : word.toCharArray()) {
			if (cur.treeNodes[ch - 'a'] != null) {
				cur = cur.treeNodes[ch - 'a'];
			} 
			else return false;
		}
		if (cur.isLeaf) {
			return true;
		}
		return false;

	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TreeNode cur = root;
		for (char ch : prefix.toCharArray()) {
			if (cur.treeNodes[ch - 'a'] != null) {
				cur = cur.treeNodes[ch - 'a'];
			} 
			else return false;
		}
		return true;
	}
}

public class _208_ImplementTrie_PrefixTree_实现前缀树的insertSearchStartwith三个方法 {
	public static void main(String[] args) {
		String word = "apple";
		String prefix = "apppleb";
		Trie obj = new Trie();
		obj.insert(word);
		System.out.println(obj.search("app"));
		 System.out.println(obj.startsWith(word));
		 System.out.println(obj.startsWith(prefix));
	}
}
