package src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示，例如 “Z”。
使用三元组表示金字塔的堆砌规则如下：
(A, B, C) 表示，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
如果可以由基层一直堆到塔尖返回true，否则返回false。
示例 1:
输入: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
输出: true
解析:
可以堆砌成这样的金字塔:
    A
   / \
  D   E
 / \ / \
X   Y   Z
因为符合('X', 'Y', 'D'), ('Y', 'Z', 'E') 和 ('D', 'E', 'A') 三种规则。
示例 2:
输入: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
输出: false
解析:
无法一直堆到塔尖。
注意：
  bottom 的长度范围在 [2, 8]。
  allowed 的长度范围在[0, 200]。
    方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。

 */
public class _756_Pyramid_Transition_Matrix_金字塔转换矩阵 {
    class Solution2 {
        private final static int M = 26;

        // 回溯，逐层枚举
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            Set<Character>[][] set = new HashSet[M][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    set[i][j] = new HashSet<>();
                }
            }
            for (String s : allowed) {
                char a = s.charAt(0);
                char b = s.charAt(1);
                char c = s.charAt(2);
                set[a - 'A'][b - 'A'].add(c);
            }
            int n = bottom.length();
            char[][] buf = new char[n][n];
            int curRow = n - 1;
            for (int i = 0; i <= curRow; i++) {
                buf[curRow][i] = bottom.charAt(i);
            }
            int curCol = 0;
            return backtrack(set, curRow - 1, curCol, buf);
        }

        private boolean backtrack(Set<Character>[][] set, int curRow, int curCol, char[][] buf) {
            if (curRow == -1) {
                return true;
            }
            assert curCol <= curRow;
            char a = buf[curRow + 1][curCol];
            char b = buf[curRow + 1][curCol + 1];
            for (char c : set[a - 'A'][b - 'A']) {
                buf[curRow][curCol] = c;
                boolean can = false;
                if (curCol < curRow) {
                    can = backtrack(set, curRow, curCol + 1, buf);
                } else {
                    can = backtrack(set, curRow - 1, 0, buf);
                }
                if (can) {
                    return true;
                }
            }
            return false;
        }
    }

    
    class Solution {
        HashMap<String, HashSet<Character>> hashmap = new HashMap<>();
        HashMap<String, Boolean> visit = new HashMap<>();

        public boolean pyramidTransition(String bottom, List<String> allowed) {
            for (String x : allowed) {
                String a = x.substring(0, 2);
                char b = x.charAt(2);
                if (!hashmap.containsKey(a))
                    hashmap.put(a, new HashSet<>());
                hashmap.get(a).add(b);
            }
            return dfs(bottom, 0, new StringBuilder());
        }

        boolean dfs(String s, int id, StringBuilder sb) {
            if (s.length() == 2)
                return hashmap.containsKey(s);
            int len = s.length();
            if (id == len - 1) {
                return dfs(sb.toString(), 0, new StringBuilder());
            }
            if (id == 0) {
                if (visit.containsKey(s))
                    return visit.get(s);
            }
            String a = s.substring(id, id + 2);
            if (!hashmap.containsKey(a))
                return false;
            for (char c : hashmap.get(a)) {
                sb.append(c);
                if (dfs(s, id + 1, sb))
                    return true;
                sb.deleteCharAt(sb.length() - 1);
            }
            if (id == 0)
                visit.put(s, false);
            return false;
        }
    }
}
