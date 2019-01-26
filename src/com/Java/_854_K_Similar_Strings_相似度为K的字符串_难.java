package src.com.Java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
示例 1：
输入：A = "ab", B = "ba"
输出：1
示例 2：
输入：A = "abc", B = "bca"
输出：2
示例 3：
输入：A = "abac", B = "baca"
输出：2
示例 4：
输入：A = "aabc", B = "abca"
输出：2
 */
public class _854_K_Similar_Strings_相似度为K的字符串_难 {
    class Solution {
        public int kSimilarity(String A, String B) {
            if (A.equals(B))
                return 0;
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.offer(A);
            int res = 0;
            visited.add(A);
            while (!q.isEmpty()) {
                res++;
                int size = q.size();
                for (int sz = 0; sz < size; sz++) {
                    String s = q.poll();
                    int i = 0;
                    while (s.charAt(i) == B.charAt(i))
                        i++;
                    for (int j = i + 1; j < s.length(); j++) {
                        if (s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j))//找到交换的位置
                            continue;
                        String temp = swap(s, i, j);
                        if (temp.equals(B))
                            return res;
                        if (visited.add(temp))
                            q.offer(temp);
                    }
                }
            }
            return res;
        }

        public String swap(String s, int i, int j) {
            char[] temp = s.toCharArray();
            char tmp = temp[i];
            temp[i] = temp[j];
            temp[j] = tmp;
            return String.valueOf(temp);
        }
    }
}
