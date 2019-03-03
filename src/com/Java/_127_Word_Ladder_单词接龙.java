package com.Java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。
说明:
    如果不存在这样的转换序列，返回 0。
    所有单词具有相同的长度。
    所有单词只由小写字母组成。
    字典中不存在重复的单词。
    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:
输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
输出: 5
解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
 */
public class _127_Word_Ladder_单词接龙 {
    // 双向bfs, dfs, string O(n ^ (d / 2)) n: 平均每层分支数, d: 起点到终点深度
    // 单向bfs O(n ^ d), 双向bfs 2 * O(n ^ (d / 2))
    // 根据算法导论, dfs与单向bfs TC相同, 均为O(V + E) V: 图的结点数, E: 图的边数
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>(wordList);
            if (!dict.contains(endWord))
                return 0;// 可变词中无目标词，直接无解
            Set<String> begins = new HashSet<>();
            Set<String> ends = new HashSet<>();
            begins.add(beginWord);
            ends.add(endWord);

            // 双向bfs
            int minDis = bfs2End(dict, begins, ends, false);
            return minDis == 0 ? 0 : 1 + minDis;// 起点也算1的长度
        }

        // 双向bfs
        // dict：可变词集     begins：起始词集    ends：目标词集    isReversed：搜索方向是否反转
        private int bfs2End(Set<String> dict, Set<String> begins, Set<String> ends, boolean isReversed) {
            if (begins.isEmpty())
                return 0;
            // 双向bfs的优化：优先选择节点个数少的队列进行扩展
            if (begins.size() > ends.size())
                return bfs2End(dict, ends, begins, !isReversed);

            dict.removeAll(begins);// 起始词不可变自身，变同层相当于白白增加路径长度，故从可变词集中去掉
            dict.removeAll(ends);// 对目标词及可变词的处理不同，故从可变词集中去掉
            // bfs中下一层通常用队列存储，这里用集合是因为nexts需要作为下一层计算的ends，有判断是否包含单词的操作，需要O(1) TC
            Set<String> nexts = new HashSet<>();// 沿当前方向的bfs下一层

            // 将本层起始词集的每一个词的每个位置的字符改为26个字符中的每一个，并判断搜索是否已完成，或者是否为有效变化
            for (String s : begins) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    char previous = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String next = new String(chars);
                        // 双向最短路径长度即为单向最短路径长度，因为对单向最短路径的搜索包含在双向搜索中
                        if (ends.contains(next))
                            return 1;// 正向与反向搜索已经连通，搜索完成，最短路径已找到，直接返回
                        else if (dict.contains(next))
                            nexts.add(next);// 搜索未完成，但是当前变化有效，可作为下一层起始词
                    }
                    chars[i] = previous;
                }
            }

            // 本层没搜到最短路径，则以目标词为起始词，本层起始词下一层为目标词，反向继续搜索
            int nextDis = bfs2End(dict, ends, nexts, !isReversed);
            return nextDis == 0 ? 0 : 1 + nextDis;
        }
    }
}
