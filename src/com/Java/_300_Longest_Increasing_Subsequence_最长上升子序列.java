package src.com.Java;

import java.util.Arrays;
import java.util.Stack;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
*/
public class _300_Longest_Increasing_Subsequence_最长上升子序列 {
    //10  res = 0 i = 0 j = 0
    //9   res = 1 i = 0 j = 0 mid = 0
    //2   res = 1 i = 0 j = 0 mid = 0
    //5   res = 1 i = 1 j = 1 mid = 0
    //3   res = 2
    //7   res = 2 i = 2 j = 2 mid = 1
    //101 res = 3 i = 2 j = 3 mid = 1
    //18  res = 4 i = 3 j = 3 mid = 3
    //res == 排好序的size i, j 相当于tails的起点，终点
    //time : O(nlogn)
    //space : O(n)
    class Solution {
        //if x is larger than all tails, append it, increase the size by 1
        //if tails[i-1] < x <= tails[i], update tails[i]
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int size = 0;
            for (int x : nums) {
                int i = 0, j = size;
                while (i != j) {
                    int m = (i + j) / 2;
                    if (tails[m] < x)
                        i = m + 1;
                    else
                        j = m;
                }
                tails[i] = x;
                if (i == size) ++size;
            }
            return size;
        }
    }

    class Solution2 {
        // Greedy Approach + DP trick - 求sequence的最小最少最短或最大最多最长解
        // track当前maxnumber和maxlength
        public int lengthOfLIS(int... nums) {
            if (nums == null || nums.length <= 0)
                return 0;
            Stack<Integer> stack = new Stack<>();
            int maxlength = 0, maxnumber = Integer.MIN_VALUE;   // step
            for (int n : nums) {
                while (!stack.isEmpty() && n <= stack.peek().intValue()) {
                    stack.pop();
                }
                stack.push(n);   // must take care two cases [10,9,2,5,3,7,101,18], [1,3,6,7,9,4,10,5,6]
                if (stack.size() > maxlength || n > maxnumber) {  // DP trick!!! [2,5,6,7,3,8]
                    maxnumber = n;
                    maxlength++;
                }
            }
            return maxlength;
        }
    }

    class Solution3 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            // Fill each position with value 1 in the array
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
            }
            // Mark one pointer at i. For each i, start from j=0.
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    // It means next number contributes to increasing sequence.
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            // Find the maximum length from the array that we just generated
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

}

