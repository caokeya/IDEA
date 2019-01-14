package src.com.Java;

import java.util.*;

/*
现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示，例如 “Z”。
使用三元组表示金字塔的堆砌规则如下：
(A, B, C) 表示，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。
当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
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
    class SolutionBFS {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : allowed) {
                map.putIfAbsent(str.substring(0, 2), new ArrayList<String>());
                map.get(str.substring(0, 2)).add(str.substring(2));
            }
            return bfs(bottom, 0, "", map);
        }

        private boolean bfs(String bot, int index, String cur, Map<String, List<String>> map) {
            int len = bot.length();
            if (len == 2)
                return map.get(bot) != null;
            if (index == len - 1) {
                return bfs(cur, 0, "", map);
            }
            String s = bot.substring(index, index + 2);
            List<String> list = map.get(s);
            if (list == null)
                return false;
            for (String str : list) {
                if (bfs(bot, index + 1, cur + str, map))
                    return true;
            }
            return false;
        }
    }

    class SolutionDFS {
        Map<String, Boolean> res;
        Map<String, Set<Character>> graph;

        public boolean pyramidTransition(String bottom, List<String> allowed) {
            if (allowed.size() == 0) return false;
            res = new HashMap<>();
            graph = new HashMap<>();

            for (String one : allowed) {
                String key = one.substring(0, 2);
                if (!graph.containsKey(key)) {
                    graph.put(key, new HashSet<Character>());
                }
                graph.get(key).add(one.charAt(2));
            }
            return dfs(bottom, new StringBuilder(), 0);
        }

        private boolean dfs(String cur, StringBuilder sb, int start) {
            if (res.containsKey(cur)) return res.get(cur);
            if (cur.length() == 1) return true;
            if (start + 2 > cur.length() && cur.length() > 1) {
                return dfs(sb.toString(), new StringBuilder(), 0);
            }
            String nowCheck = cur.substring(start, start + 2);
            int len = sb.length();
            if (!graph.containsKey(nowCheck)) {
                return false;
            } else {
                Set<Character> nextChar = graph.get(nowCheck);
                for (char c : nextChar) {
                    sb.append(c);
                    if (dfs(cur, sb, start + 1)) {
                        res.put(cur, true);
                        return true;
                    }
                    sb.setLength(len);
                }
                if (start == 0) res.put(cur, false);
                return false;
            }
        }
    }
}
