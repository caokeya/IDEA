package src.com.Java;

/*
给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
注意：1 ≤ k ≤ n ≤ 109。
示例 :
输入:
n: 13   k: 2
输出:
10
解释:
字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 */
public class _440_Kth_Smallest_in_Lexicographical_Order_字典序的第K小数字_难 {
    class Solution {
        public int findKthNumber(int n, int k) {
            int curr = 1;
            k = k - 1;
            while (k > 0) {
                int steps = calSteps(n, curr, curr + 1);
                if (steps <= k) {
                    curr += 1;
                    k -= steps;
                } else {
                    curr *= 10;
                    k -= 1;
                }
            }
            return curr;
        }

        // use long in case of overflow
        public int calSteps(int n, long n1, long n2) {
            int steps = 0;
            while (n1 <= n) {
                steps += Math.min(n + 1, n2) - n1;
                n1 *= 10;
                n2 *= 10;
            }
            return steps;
        }
    }
}
