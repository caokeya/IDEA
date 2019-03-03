package com.Java;

import java.util.HashSet;
import java.util.Set;

/*
如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
    n >= 3
    对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
（回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），
    而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
示例 1：
输入: [1,2,3,4,5,6,7,8]
输出: 5
解释:
最长的斐波那契式子序列为：[1,2,3,5,8] 。
示例 2：
输入: [1,3,7,11,12,14,18]
输出: 3
解释:
最长的斐波那契式子序列有：
[1,11,12]，[3,11,14] 以及 [7,11,18] 。
 */
public class _873_Length_of_Longest_Fibonacci_Subsequence_最长的斐波那契子序列的长度 {
    class Solution {
        public int lenLongestFibSubseq(int[] A) {
            if (A == null) {
                return -1;
            }
            Set<Integer> s = new HashSet<>();
            for (int i : A)
                s.add(i);
            int res = 2;
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    int a = A[i];
                    int b = A[j];
                    int l = 2;
                    while (s.contains(a + b)) {
                        b = b + a;
                        a = b - a;
                        l++;
                    }
                    res = Math.max(res, l);
                }
            }
            return res > 2 ? res : 0;
        }
    }
    
    class Solution2 {
        public int lenLongestFibSubseq(int[] A) {
            if (A == null || A.length < 3) return 0;
            int len = A.length;
            int[][] dp = new int[len][len];
            int res = 0;
            for (int i = 1; i < len; i++) {
                int l = 0, r = i - 1;
                while (l < r) {
                    int sum = A[l] + A[r];
                    if (A[i] > sum) {
                        l++;
                    } else if (A[i] < sum) {
                        r--;
                    } else {
                        dp[r][i] = dp[l][r] + 1;
                        res = Math.max(res, dp[r][i]);
                        r--;
                        l++;
                    }
                }
            }
            return res == 0 ? 0 : res + 2;
        }
    }
}
