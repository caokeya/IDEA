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
    class Solution {
        public int getMoneyAmount(int n) {
            return getMoneyAmount(1, n, new int[n][n]);
        }

        public int getMoneyAmount(int l, int r, int[][] memo) {
            if (l >= r)
                return 0;
            if (l + 1 == r)
                return l;
            if (l + 2 == r)
                return l + 1;

            if (memo[l - 1][r - 1] != 0)
                return memo[l - 1][r - 1];
            int res = Integer.MAX_VALUE;
            for (int i = l; i <= r; i++) {
                int left = getMoneyAmount(l, i - 1, memo);
                int right = getMoneyAmount(i + 1, r, memo);
                res = Math.min(res, Math.max(left, right) + i);
            }
            memo[l - 1][r - 1] = res;
            return res;
        }

    }
}
