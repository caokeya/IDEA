package src.com.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
的最短转换序列。转换需遵循如下规则： 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典中的单词。
说明:
    如果不存在这样的转换序列，返回一个空列表。
    所有单词具有相同的长度。 
    所有单词只由小写字母组成。 
    字典中不存在重复的单词。
    你可以假设 beginWord和 endWord 是非空的，且二者不相同。
示例 1:
输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
 */
public class _126_Word_Ladder_II_单词接龙2_难 {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>(wordList);
            if (!dict.contains(endWord))
                return new ArrayList<>();// 可变词中无目标词，直接无解
            Set<String> begins = new HashSet<>();
            Set<String> ends = new HashSet<>();
            begins.add(beginWord);
            ends.add(endWord);
            Map<String, List<String>> map = new HashMap<>();// 有效的正向可变单词及其对应的所有下一层可变词

            bfs2End(dict, begins, ends, map, false);// 双向bfs，建立map

            List<List<String>> result = new ArrayList<>();
            // 根据已建立的map，dfs搜索有效路径。由于之前的bfs的剪枝作用，此时有效即为最短
            dfs(map, result, new ArrayList<>(Arrays.asList(beginWord)), beginWord, endWord);

            return result;
        }

        // 双向bfs，建立正向搜索用的map
        // dict：可变词集 begins：起始词集 ends：目标词集 isReversed：搜索方向是否反转
        private boolean bfs2End(Set<String> dict, Set<String> begins, Set<String> ends, Map<String, List<String>> map,
                boolean isReversed) {
            if (begins.isEmpty())
                return false;
            if (begins.size() > ends.size())
                return bfs2End(dict, ends, begins, map, !isReversed);

            dict.removeAll(begins);
            dict.removeAll(ends);
            boolean done = false;// 正向与反向搜索是否已经存在连通路径
            Set<String> nexts = new HashSet<>();// 沿当前方向的bfs下一层

            // 将本层起始词集的每一个词的每个位置的字符改为26个字符中的每一个，并判断搜索是否已完成，或者是否为有效变化
            for (String s : begins) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    char previous = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String next = new String(chars);
                        String key = isReversed ? next : s;// 搜索可以反转，但是map的建立一直沿正向，所以key val关系要正确
                        String val = isReversed ? s : next;

                        if (ends.contains(next)) {// 搜索完成
                            done = true;// 正向与反向搜索已经连通，但要收集最短长度的所有连通路径信息，所以本层起始词集bfs计算完成后才停止向下一层搜索
                            // 建立路径信息
                            if (!map.containsKey(key))
                                map.put(key, new ArrayList<>());
                            map.get(key).add(val);
                        } else if (dict.contains(next)) {// 搜索未完成，但是当前变化有效，可作为下一层起始词
                            nexts.add(next);
                            // 建立路径信息
                            if (!map.containsKey(key))
                                map.put(key, new ArrayList<>());
                            map.get(key).add(val);
                        }
                    }
                    chars[i] = previous;
                }
            }

            // 如果本层搜索已经找到最短路径，则下一层的搜索不会进行，bfs终止
            // 否则以目标词为起始词，本层起始词下一层为目标词，反向继续搜索
            return done || bfs2End(dict, ends, nexts, map, !isReversed);
        }

        // dfs，根据已建立的map搜索有效路径
        private void dfs(Map<String, List<String>> map, List<List<String>> result, List<String> buff, String start,
                String end) {
            if (start.equals(end)) {
                result.add(new ArrayList<>(buff));
                return;
            }
            if (!map.containsKey(start))
                return;

            for (String next : map.get(start)) {
                buff.add(next);
                dfs(map, result, buff, next, end);
                buff.remove(buff.size() - 1);
            }
        }
    }
}
