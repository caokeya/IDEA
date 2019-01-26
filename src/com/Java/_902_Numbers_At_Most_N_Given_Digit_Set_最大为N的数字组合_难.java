package src.com.Java;

/*
我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
示例 1：
输入：D = ["1","3","5","7"], N = 100
输出：20
解释：
可写出的 20 个数字是：
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
示例 2：
输入：D = ["1","4","9"], N = 1000000000
输出：29523
解释：
我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
81 个四位数字，243 个五位数字，729 个六位数字，
2187 个七位数字，6561 个八位数字和 19683 个九位数字。
总共，可以使用D中的数字写出 29523 个整数。
 */
public class _902_Numbers_At_Most_N_Given_Digit_Set_最大为N的数字组合_难 {
    /*
     * 即对于数字N从右往左扫描，如果对于一个扫描的点，再遍历D。
     * 1.如果D中的一个数字小于N中的当前值，那么当前位置的组合数就加上D长度的一个次幂，
         具体多少次幂，取决于N中当前位置，相当于就是 1XXX, 2abc组合数就是D长度的3次幂。
     * 2.如果D中的一个数字等于N中的当前值，那么就加上前一个位置的组合数，相当于就是 1XXXX 和 1XXXX；组合数取决于后4位。
     * 3.如果D中的一个数字比N中的当前值大，其实不用处理，因为我们设定的DP数组初始值都是0；
     */
    class Solution {
        public int atMostNGivenDigitSet(String[] D, int N) {
            String S = String.valueOf(N);
            int K = S.length();
            int[] dp = new int[K + 1];
            dp[K] = 1;

            for (int i = K - 1; i >= 0; --i) {
                // compute dp[i]
                int Si = S.charAt(i) - '0';
                for (String d : D) {
                    if (Integer.valueOf(d) < Si)
                        dp[i] += Math.pow(D.length, K - i - 1);
                    else if (Integer.valueOf(d) == Si)
                        dp[i] += dp[i + 1];
                }
            }

            for (int i = 1; i < K; ++i)
                dp[0] += Math.pow(D.length, i);
            return dp[0];
        }
    }
}
