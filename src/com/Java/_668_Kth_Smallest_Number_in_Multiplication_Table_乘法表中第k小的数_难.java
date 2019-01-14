package src.com.Java;

/*
几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
例 1：
输入: m = 3, n = 3, k = 5
输出: 3
解释: 
乘法表:
1   2   3
2   4   6
3   6   9
第5小的数字是 3 (1, 2, 2, 3, 3).
例 2：
输入: m = 2, n = 3, k = 6
输出: 6
解释: 
乘法表:
1   2   3
2   4   6
第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 */
public class _668_Kth_Smallest_Number_in_Multiplication_Table_乘法表中第k小的数_难 {
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int low = 1, high = m * n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int count = helper(m, n, mid);
                if (count >= k)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return low;
        }

        private int helper(int m, int n, int num) {
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(num / i, n);
            }
            return count;
        }
    }
}
