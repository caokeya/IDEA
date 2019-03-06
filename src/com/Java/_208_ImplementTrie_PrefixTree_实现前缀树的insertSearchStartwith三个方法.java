package src.src.com.Java;

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
public class _208_ImplementTrie_PrefixTree_实现前缀树的insertSearchStartwith三个方法 {
    class Trie {

        Node root;

        class Node {
            Node[] children = new Node[26];
            boolean end = false;
        }

        /* Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /* Inserts a word into the trie. */
        public void insert(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null)
                    p.children[c - 'a'] = new Node();
                p = p.children[c - 'a'];
            }
            p.end = true;
        }

        /* Returns if the word is in the trie. */
        public boolean search(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    return false;
                }
                p = p.children[c - 'a'];
            }
            return p.end;
        }

        /* Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node p = root;
            for (char c : prefix.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    return false;
                }
                p = p.children[c - 'a'];
            }
            return true;
        }
    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}


