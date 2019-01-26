package src.com.Java;

/*
给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
示例 1:
输入: 5
输出: 2
解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
示例 2:
输入: 9
输出: 3
解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
示例 3:
输入: 15
输出: 4
解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 */
public class _829_Consecutive_Numbers_Sum_连续整数求和 {
    /*
    N可以表示为k + 1 k + 2，…k + i, k是正整数;因此
    N = k * i + (i + 1) * i / 2 =>
    N - (i + 1) * i / 2 = k * i，这意味着只要N - (i + 1) * i / 2 = k乘以i，就得到i对应的解;
    因此，从1开始迭代所有可能的i值，将覆盖问题的所有情况。
     */
    class Solution {
        public int consecutiveNumbersSum(int N) {
            int ans = 1;
            for (int i = 2; i * (i + 1) / 2 <= N; ++i) {
                if ((N - i * (i + 1) / 2) % i == 0)
                    ++ans;
            }
            return ans;
        }
    }
}
