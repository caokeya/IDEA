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

        /*
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            map = new HashMap<>();
        }

        /*
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String s : dict) {
                int len = s.length();
                if (!map.containsKey(len))
                    map.put(len, new HashSet<>());
                map.get(len).add(s);
            }
        }

        /*
         * Returns if there is any word in the trie that equals to the given word after
         * modifying exactly one character
         */
        public boolean search(String word) {
            if (!map.containsKey(word.length()))
                return false;
            Set<String> set = map.get(word.length());
            char[] wordc = word.toCharArray();
            for (int i = 0; i < wordc.length; i++) {
                char wordi = wordc[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (wordi != c) {
                        wordc[i] = c;
                        if (set.contains(new String(wordc)))
                            return true;
                    }
                }
                wordc[i] = wordi;
            }
            return false;
        }
    }

    class MagicDictionarySet {

        HashSet<String> dictSet;

        /*
         * Initialize your data structure here.
         */
        public MagicDictionarySet() {
            dictSet = new HashSet<>();
        }

        /*
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            dictSet = new HashSet<String>();
            for (String word : dict)
                dictSet.add(word);
        }

        /*
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != ch) {
                        chars[i] = c;
                        if (dictSet.contains(new String(chars)))
                            return true;
                    }
                }
                chars[i] = ch;
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
