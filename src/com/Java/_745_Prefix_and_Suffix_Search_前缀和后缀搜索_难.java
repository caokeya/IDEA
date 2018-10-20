package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定多个 words，words[i] 的权重为 i 。
设计一个类 WordFilter 实现函数WordFilter.f(String prefix, String suffix)。这个函数将返回具有前缀 prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。
例子:
输入:
WordFilter(["apple"])
WordFilter.f("a", "e") // 返回 0
WordFilter.f("b", "") // 返回 -1
 */
public class _745_Prefix_and_Suffix_Search_前缀和后缀搜索_难 {
    class WordFilter {

        Map<String, List<Integer>> prefixMap = new HashMap<>();
        Map<String, List<Integer>> suffixMap = new HashMap<>();

        public WordFilter(String[] words) {
            for (int w = 0; w < words.length; w++) {
                // put words[w]. prefix as key, , w is the weight, ordered by insert sequence

                for (int i = 0; i <= 10 && i <= words[w].length(); i++) {
                    String prefix = words[w].substring(0, i);
                    List<Integer> list = prefixMap.getOrDefault(prefix, new ArrayList<>());
                    list.add(w);
                    prefixMap.put(prefix, list);
                }

                for (int i = 0; i <= 10 && i <= words[w].length(); i++) {
                    String suffix = words[w].substring(words[w].length() - i);
                    List<Integer> list = suffixMap.getOrDefault(suffix, new ArrayList<>());
                    list.add(w);
                    suffixMap.put(suffix, list);
                }

            }
        }

        public int f(String prefix, String suffix) {
            if (!prefixMap.containsKey(prefix) || !suffixMap.containsKey(suffix)) {
                return -1;
            }
            List<Integer> plist = prefixMap.get(prefix);
            List<Integer> slist = suffixMap.get(suffix);
            int p = plist.size() - 1;
            int s = slist.size() - 1;
            while (p >= 0 && s >= 0) {
                if (plist.get(p) < slist.get(s)) {
                    s--;
                } else if (plist.get(p) > slist.get(s)) {
                    p--;
                } else {
                    return plist.get(p);
                }
            }
            return -1;
        }
    }

    class WordFilter2 {
        private class TrieNode {
            TrieNode[] children;
            int weight;

            public TrieNode() {
                children = new TrieNode[27];
                weight = 0;
            }
        }

        TrieNode trie;

        public WordFilter2(String[] words) {
            trie = new TrieNode();
            for (int weight = 0; weight < words.length; ++weight) {
                String word = words[weight] + "#"; // '{' - 'a' => 26
                for (int i = 0; i < word.length(); ++i) {
                    TrieNode cur = trie;
                    cur.weight = weight;
                    for (int j = i; j < 2 * word.length() - 1; ++j) {
                        int k = word.charAt(j % word.length()) - 'a';
                        if (cur.children[k] == null) {
                            cur.children[k] = new TrieNode();
                        }
                        cur = cur.children[k];
                        cur.weight = weight;
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            TrieNode cur = trie;
            for (char letter : (suffix + '#' + prefix).toCharArray()) {
                if (cur.children[letter - 'a'] == null) {
                    return -1;
                }
                cur = cur.children[letter - 'a'];
            }
            return cur.weight;
        }
    }
    /**
     * Your WordFilter object will be instantiated and called as such:
     * WordFilter obj = new WordFilter(words);
     * int param_1 = obj.f(prefix,suffix);
     */
}
