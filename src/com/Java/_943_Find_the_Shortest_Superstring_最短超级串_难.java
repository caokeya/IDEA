package com.Java;

import java.util.Arrays;
import java.util.Stack;

/*
给定一个字符串数组 A，找到以 A 中每个字符串作为子字符串的最短字符串。
我们可以假设 A 中没有字符串是 A 中另一个字符串的子字符串。
示例 1：
输入：["alex","loves","leetcode"]
输出："alexlovesleetcode"
解释："alex"，"loves"，"leetcode" 的所有排列都会被接受。
示例 2：
输入：["catg","ctaagt","gcta","ttca","atgcatc"]
输出："gctaagttcatgcatc"
 */
public class _943_Find_the_Shortest_Superstring_最短超级串_难 {
    class Solution {
        public String shortestSuperstring(String[] A) {
            int n = A.length;
            int[][] graph = new int[n][n];
            // build the graph
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = calc(A[i], A[j]);
                    graph[j][i] = calc(A[j], A[i]);
                }
            }
            int[][] dp = new int[1 << n][n];
            int[][] path = new int[1 << n][n];
            int last = -1, min = Integer.MAX_VALUE;

            // start TSP DP
            for (int i = 1; i < (1 << n); i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        int prev = i - (1 << j);
                        if (prev == 0) {
                            dp[i][j] = A[j].length();
                        } else {
                            for (int k = 0; k < n; k++) {
                                if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                    dp[i][j] = dp[prev][k] + graph[k][j];
                                    path[i][j] = k;
                                }
                            }
                        }
                    }
                    if (i == (1 << n) - 1 && dp[i][j] < min) {
                        min = dp[i][j];
                        last = j;
                    }
                }
            }

            // build the path
            StringBuilder sb = new StringBuilder();
            int cur = (1 << n) - 1;
            Stack<Integer> stack = new Stack<>();
            while (cur > 0) {
                stack.push(last);
                int temp = cur;
                cur -= (1 << last);
                last = path[temp][last];
            }

            // build the result
            int i = stack.pop();
            sb.append(A[i]);
            while (!stack.isEmpty()) {
                int j = stack.pop();
                sb.append(A[j].substring(A[j].length() - graph[i][j]));
                i = j;
            }
            return sb.toString();
        }

        private int calc(String a, String b) {
            for (int i = 1; i < a.length(); i++) {
                if (b.startsWith(a.substring(i))) {
                    return b.length() - a.length() + i;
                }
            }
            return b.length();
        }
    }

    class Solution2 {
        public String shortestSuperstring(String[] A) {
            int N = A.length;

            // Populate overlaps
            int[][] overlaps = new int[N][N];
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    if (i != j) {
                        int m = Math.min(A[i].length(), A[j].length());
                        for (int k = m; k >= 0; --k)
                            if (A[i].endsWith(A[j].substring(0, k))) {
                                overlaps[i][j] = k;
                                break;
                            }
                    }

            // dp[mask][i] = most overlap with mask, ending with ith element
            int[][] dp = new int[1 << N][N];
            int[][] parent = new int[1 << N][N];
            for (int mask = 0; mask < (1 << N); ++mask) {
                Arrays.fill(parent[mask], -1);

                for (int bit = 0; bit < N; ++bit)
                    if (((mask >> bit) & 1) > 0) {
                        // Let's try to find dp[mask][bit]. Previously, we had
                        // a collection of items represented by pmask.
                        int pmask = mask ^ (1 << bit);
                        if (pmask == 0)
                            continue;
                        for (int i = 0; i < N; ++i)
                            if (((pmask >> i) & 1) > 0) {
                                // For each bit i in pmask, calculate the value
                                // if we ended with word i, then added word 'bit'.
                                int val = dp[pmask][i] + overlaps[i][bit];
                                if (val > dp[mask][bit]) {
                                    dp[mask][bit] = val;
                                    parent[mask][bit] = i;
                                }
                            }
                    }
            }

            // # Answer will have length sum(len(A[i]) for i) - max(dp[-1])
            // Reconstruct answer, first as a sequence 'perm' representing
            // the indices of each word from left to right.

            int[] perm = new int[N];
            boolean[] seen = new boolean[N];
            int t = 0;
            int mask = (1 << N) - 1;

            // p: the last element of perm (last word written left to right)
            int p = 0;
            for (int j = 0; j < N; ++j)
                if (dp[(1 << N) - 1][j] > dp[(1 << N) - 1][p])
                    p = j;

            // Follow parents down backwards path that retains maximum overlap
            while (p != -1) {
                perm[t++] = p;
                seen[p] = true;
                int p2 = parent[mask][p];
                mask ^= 1 << p;
                p = p2;
            }

            // Reverse perm
            for (int i = 0; i < t / 2; ++i) {
                int v = perm[i];
                perm[i] = perm[t - 1 - i];
                perm[t - 1 - i] = v;
            }

            // Fill in remaining words not yet added
            for (int i = 0; i < N; ++i)
                if (!seen[i])
                    perm[t++] = i;

            // Reconstruct final answer given perm
            StringBuilder ans = new StringBuilder(A[perm[0]]);
            for (int i = 1; i < N; ++i) {
                int overlap = overlaps[perm[i - 1]][perm[i]];
                ans.append(A[perm[i]].substring(overlap));
            }

            return ans.toString();
        }
    }
}
