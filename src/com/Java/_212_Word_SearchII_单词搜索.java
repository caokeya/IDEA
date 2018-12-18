package src.com.Java;

import java.util.ArrayList;
import java.util.List;



/** 
* @author  suzw
* @version 创建时间：2018年9月11日 下午8:52:12 
* 类说明 
* 212使用前缀树Trie解答，79使用常规方法
* https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
* Intuitively, start from every cell and try to build a word in the dictionary. Backtracking (dfs) is the powerful way to exhaust every possible ways. Apparently, we need to do pruning when current character is not in any word.

How do we instantly know the current character is invalid? HashMap?
How do we instantly know what's the next valid character? LinkedList?
But the next character can be chosen from a list of characters. "Mutil-LinkedList"?

Combing them, Trie is the natural choice. Notice that:

TrieNode is all we need. search and startsWith are useless.
No need to store character at TrieNode. c.next[i] != null is enough.
Never use c1 + c2 + c3. Use StringBuilder.
No need to use O(n^2) extra space visited[m][n].
No need to use StringBuilder. Storing word itself at leaf node is enough.
No need to use HashSet to de-duplicate. Use "one time search" trie.
*/
public class _212_Word_SearchII_单词搜索 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
public List<String>	findWords(char[][] board, String[] words){
	List<String> res = new ArrayList<>();
	TrieNode root = buildTrie(words);
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[i].length; j++) {
			dfs(board, i, j, root, res);
		}
	}
	return res;
}

public void dfs(char[][] board ,int i,int j,TrieNode p, List<String> res) {
	char c = board[i][j];
	//碰到边界、已访问时，返回
	if (c == '#' || p.next[c - 'a'] == null) return;
	p = p.next[c - 'a'];
	
	
	if (p.word != null) {	//当找到叶子节点【一个单词结束】，放进List
		res.add(p.word);
		p.word = null;
	}

	board[i][j] = '#';
	if(i>0) dfs(board, i-1, j, p, res);
	if(j>0) dfs(board, i, j-1, p, res);
	if(i<board.length-1) dfs(board, i+1, j, p, res);
	if(j<board[0].length-1) dfs(board, i, j+1, p, res);
	board[i][j]=c;
}
public TrieNode buildTrie(String[] words) {
	TrieNode root = new TrieNode();
	for (String w : words) {
		TrieNode p = root;
		for (char c : w.toCharArray()) {
			if (p.next[c - 'a'] == null) p.next[c - 'a'] = new TrieNode();
			p = p.next[c - 'a'];
		}
		p.word = w;
	}
	return root;
}

	class TrieNode{
		TrieNode[] next = new TrieNode[26];
		String word;
		}
}
