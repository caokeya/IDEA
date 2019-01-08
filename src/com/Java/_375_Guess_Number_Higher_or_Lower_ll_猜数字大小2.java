package src.com.Java;

/*
我们正在玩一个猜数游戏，游戏规则如下：
我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
示例:
n = 10, 我选择了8.
第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
游戏结束。8 就是我选的数字。
你最终要支付 5 + 7 + 9 = 21 块钱。
给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
 */
public class _375_Guess_Number_Higher_or_Lower_ll_猜数字大小2 {
    public class Solution {
        public int getMoneyAmount(int n) {
            int[][] table = new int[n + 1][n + 1];
            return DP(table, 1, n);
        }

        int DP(int[][] t, int s, int e) {
            if (s >= e) return 0;
            if (t[s][e] != 0) return t[s][e];
            int res = Integer.MAX_VALUE;
            for (int x = s; x <= e; x++) {
                int tmp = x + Math.max(DP(t, s, x - 1), DP(t, x + 1, e));
                res = Math.min(res, tmp);
            }
            t[s][e] = res;
            return res;
        }
    }

    public class Solution2 {
        public int getMoneyAmount(int n) {
            int[][] table = new int[n + 1][n + 1];
            for (int j = 2; j <= n; j++) {
                for (int i = j - 1; i > 0; i--) {
                    int globalMin = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        int localMax = k + Math.max(table[i][k - 1], table[k + 1][j]);
                        globalMin = Math.min(globalMin, localMax);
                    }
                    table[i][j] = i + 1 == j ? i : globalMin;
                }
            }
            return table[1][n];
        }
    }
}
