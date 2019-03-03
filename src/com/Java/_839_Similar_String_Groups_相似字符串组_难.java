package com.Java;

/*
如果我们交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。
例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。
注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
我们给出了一个不包含重复的字符串列表 A。列表中的每个字符串都是 A 中其它所有字符串的一个字母异位词。请问 A 中有多少个相似字符串组？
示例：
输入：["tars","rats","arts","star"]
输出：2
 */
public class _839_Similar_String_Groups_相似字符串组_难 {
    class Solution2 {
        public int numSimilarGroups(String[] A) {
            if (A.length < 2)
                return A.length;
            int res = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == null)
                    continue;
                String str = A[i];
                A[i] = null;
                res++;
                dfs(A, str);
            }
            return res;
        }

        public void dfs(String[] arr, String str) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null)
                    continue;
                if (helper(str, arr[i])) {// both string str and arr[i] belong in same group
                    String s = arr[i];
                    arr[i] = null;
                    dfs(arr, s);
                }
            }
        }

        public boolean helper(String s, String t) {
            int res = 0, i = 0;
            while (res <= 2 && i < s.length()) {
                if (s.charAt(i) != t.charAt(i))
                    res++;
                i++;
            }
            return res == 2 || res == 0;//等于零的情况考虑两个字符串相等
        }
    }
}
