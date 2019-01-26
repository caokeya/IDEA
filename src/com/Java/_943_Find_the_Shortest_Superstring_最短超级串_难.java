package src.com.Java;

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
    /*
    图[i][j]表示当A[i]后跟A[j]时要追加的字符串长度。如。A[i] = abcd, A[j] = bcde，则图[i][j] = 1
    那么问题就变成了:在这个图中找出恰好访问每个节点一次的最短路径。这是一个旅行推销员的问题。
    应用TSP DP解决方案。记住要记录路径。
     */
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
}
