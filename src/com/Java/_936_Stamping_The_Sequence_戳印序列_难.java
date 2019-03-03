package com.Java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
你想要用小写字母组成一个目标字符串 target。 
开始的时候，序列由 target.length 个 '?' 记号组成。而你有一个小写字母印章 stamp。
在每个回合，你可以将印章放在序列上，并将序列中的每个字母替换为印章上的相应字母。你最多可以进行 10 * target.length  个回合。
举个例子，如果初始序列为 "?????"，而你的印章 stamp 是 "abc"，那么在第一回合，你可以得到 "abc??"、"?abc?"、"??abc"。（请注意，印章必须完全包含在序列的边界内才能盖下去。）
如果可以印出序列，那么返回一个数组，该数组由每个回合中被印下的最左边字母的索引组成。如果不能印出序列，就返回一个空数组。
例如，如果序列是 "ababc"，印章是 "abc"，那么我们就可以返回与操作 "?????" -> "abc??" -> "ababc" 相对应的答案 [0, 2]；
另外，如果可以印出序列，那么需要保证可以在 10 * target.length 个回合内完成。任何超过此数字的答案将不被接受。
示例 1：
输入：stamp = "abc", target = "ababc"
输出：[0,2]
（[1,0,2] 以及其他一些可能的结果也将作为答案被接受）
示例 2：
输入：stamp = "aabcaca", target = "abca"
输出：[3,0,1]
 */
public class _936_Stamping_The_Sequence_戳印序列_难 {
    class Solution {
        public int[] movesToStamp(String stamp, String target) {
            int M = stamp.length(), N = target.length();
            Queue<Integer> queue = new ArrayDeque<Integer>();
            boolean[] done = new boolean[N];
            Stack<Integer> ans = new Stack<Integer>();
            List<Node> A = new ArrayList<Node>();
            for (int i = 0; i <= N - M; ++i) {
                // For each window [i, i+M), A[i] will contain
                // info on what needs to change before we can
                // reverse stamp at this window.
                Set<Integer> made = new HashSet<Integer>();
                Set<Integer> todo = new HashSet<Integer>();
                for (int j = 0; j < M; ++j) {
                    if (target.charAt(i + j) == stamp.charAt(j))
                        made.add(i + j);
                    else
                        todo.add(i + j);
                }
                A.add(new Node(made, todo));
                // If we can reverse stamp at i immediately,
                // enqueue letters from this window.
                if (todo.isEmpty()) {
                    ans.push(i);
                    for (int j = i; j < i + M; ++j)
                        if (!done[j]) {
                            queue.add(j);
                            done[j] = true;
                        }
                }
            }
            // For each enqueued letter (position),
            while (!queue.isEmpty()) {
                int i = queue.poll();
                // For each window that is potentially affected,
                // j: start of window
                for (int j = Math.max(0, i - M + 1); j <= Math.min(N - M, i); ++j) {
                    if (A.get(j).todo.contains(i)) { // This window is affected
                        A.get(j).todo.remove(i);
                        if (A.get(j).todo.isEmpty()) {
                            ans.push(j);
                            for (int m : A.get(j).made)
                                if (!done[m]) {
                                    queue.add(m);
                                    done[m] = true;
                                }
                        }
                    }
                }
            }

            for (boolean b : done)
                if (!b)
                    return new int[0];
            int[] ret = new int[ans.size()];
            int t = 0;
            while (!ans.isEmpty())
                ret[t++] = ans.pop();
            return ret;
        }
    }

    class Node {
        Set<Integer> made, todo;

        Node(Set<Integer> m, Set<Integer> t) {
            made = m;
            todo = t;
        }
    }

    class Solution2 {
        public int[] movesToStamp(String s, String t) {
            List<Integer> res = new ArrayList<>();
            char[] tmp = new char[t.length()];
            Arrays.fill(tmp, '*');
            String dst = new String(tmp);

            while (!t.equals(dst))
                if ((t = unDo(t, s, res)) == null)
                    return new int[0];

            int[] ret = new int[res.size()];
            for (int i = 0; i < res.size(); i++)
                ret[i] = res.get(res.size() - i - 1);
            return ret;
        }

        String unDo(String cur, String s, List<Integer> res) {
            char[] a = cur.toCharArray();
            for (int i = 0; i <= a.length - s.length(); i++) {
                int idx0 = i, idx1 = 0;
                boolean hasChar = false;
                while (idx0 < a.length && idx1 < s.length() && (a[idx0] == '*' || a[idx0] == s.charAt(idx1))) {
                    if (!hasChar && a[idx0] != '*')
                        hasChar = true;
                    idx0++;
                    idx1++;
                }

                if (idx1 == s.length() && hasChar) {
                    res.add(i);
                    Arrays.fill(a, i, i + s.length(), '*');
                    return new String(a);
                }
            }
            return null;
        }
    }
}
