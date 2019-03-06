package src.src.com.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 给定两个字符串 s 和 t，判断它们是否是同构的。
 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 示例 1:
 输入: s = "egg", t = "add"
 输出: true
 示例 2:
 输入: s = "foo", t = "bar"
 输出: false
 示例 3:
 输入: s = "paper", t = "title"
 输出: true
*/
public class _205_Isomorphic_Strings_是否是同型字符串 {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            int[] map1 = new int[256];
            int[] map2 = new int[256];
            Arrays.fill(map1, -1);
            Arrays.fill(map2, -1);
            for (int i = 0; i < s.length(); i++) {
                if (map1[s.charAt(i)] != map2[t.charAt(i)]) {
                    return false;
                }
                map1[s.charAt(i)] = map2[t.charAt(i)] = i;
            }
            return true;
        }
    }
}
