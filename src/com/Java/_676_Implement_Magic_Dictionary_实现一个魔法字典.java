package src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
实现一个带有buildDict, 以及 search方法的魔法字典。
对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
示例 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
 */
public class _676_Implement_Magic_Dictionary_实现一个魔法字典 {
    class MagicDictionary {

        Map<Integer, Set<String>> map;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            map = new HashMap<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String s : dict) {
                int len = s.length();
                if (!map.containsKey(len))
                    map.put(len, new HashSet<>());
                map.get(len).add(s);
            }
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after
         * modifying exactly one character
         */
        public boolean search(String word) {
            if (!map.containsKey(word.length()))
                return false;
            Set<String> set = map.get(word.length());
            char[] wc = word.toCharArray();
            for (int i = 0; i < wc.length; i++) {
                char og = wc[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (og != c) {
                        wc[i] = c;
                        if (set.contains(new String(wc)))
                            return true;
                    }
                }
                wc[i] = og;
            }
            return false;
        }
    }
    
    class MagicDictionary2 {
        Set<String> set;

        /** Initialize your data structure here. */
        public MagicDictionary2() {
            this.set = new HashSet<String>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String s : dict)
                set.add(s);
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after
         * modifying exactly one character
         */
        public boolean search(String word) {
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char orig = arr[i];
                for (int j = 0; j < 26; j++) {
                    char cur = (char) ('a' + j);
                    if (orig == cur)
                        continue;
                    arr[i] = cur;
                    if (set.contains(String.valueOf(arr)))
                        return true;
                }
                arr[i] = orig;
            }
            return false;
        }
    }
    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dict);
     * boolean param_2 = obj.search(word);
     */
}
