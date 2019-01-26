package src.com.Java;

/*
你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。
你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。
返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。
示例 1：
输入：[1,2,3,6]
输出：6
解释：我们有两个不相交的子集 {1,2,3} 和 {6}，它们具有相同的和 sum = 6。
示例 2：
输入：[1,2,3,4,5,6]
输出：10
解释：我们有两个不相交的子集 {2,3,5} 和 {4,6}，它们具有相同的和 sum = 10。
示例 3：
输入：[1,2]
输出：0
解释：没法安装广告牌，所以返回 0。
 */
public class _956_Tallest_Billboard_最高的广告牌_难 {
    /*
    dp[d]是指通过对差d可以得到的最大和对
    例如，如果有一对和(a, b)和啊a > b，那么dp[a - b] = b
    如果我们有dp[diff] = a，这意味着我们有一对和(a, a + diff)
    这是diff = a的最大对
    case 1
        If put x to tall side
        ------- y ------|----- d -----|----- x -----|
        ------- y ------|
        We update dp[d + x] = max(dp[d + x], y )
    case 2.1
        Put x to low side and d >= x:
        -------y------|----- d -----|
        -------y------|--- x ---|
        We update dp[d-x] = max( dp[d - x], y + x)
    case 2.2
        Put x to low side and d < x:
        ------- y ------|----- d -----|
        ------- y ------|------- x -------|
        We update dp[x - d] = max(dp[x - d], y + d)
    case 2.1 and case2.2 can merge into dp[abs(x - d)] = max(dp[abs(x - d)], y + min(d, x))
     */
    class Solution {
        public int tallestBillboard(int[] rods) {
            int[] dp = new int[5001];
            for (int d = 1; d < 5001; d++)
                dp[d] = -10000;
            for (int x : rods) {
                int[] cur = dp.clone();
                for (int d = 0; d + x < 5001; d++) {
                    dp[d + x] = Math.max(dp[d + x], cur[d]);
                    dp[Math.abs(d - x)] = Math.max(dp[Math.abs(d - x)], cur[d] + Math.min(d, x));
                }
            }
            return dp[0];
        }
    }
}
