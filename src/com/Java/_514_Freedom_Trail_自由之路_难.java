package com.Java;

/*
视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
旋转 ring 拼出 key 字符 key[i] 的阶段中：
    您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
    如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
示例：
输入: ring = "godding", key = "gd"
输出: 4
解释:
 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 当然, 我们还需要1步进行拼写。
 因此最终的输出是 4。
 */
public class _514_Freedom_Trail_自由之路_难 {
    class Solution {
        public int findRotateSteps(String ring, String key) {
            int[][] dp = new int[ring.length()][key.length()];
            return dfs(ring.toCharArray(), key.toCharArray(), dp, 0, 0);
        }

        private int dfs(char[] ring, char[] key, int[][] dp, int i, int j) {
            if (j == key.length)
                return 0;
            if (dp[i][j] != 0)
                return dp[i][j];
            int res = Integer.MAX_VALUE;
            for (int k = 0; k < ring.length; k++) {
                if (ring[k] == key[j]) {
                    int diff = Math.abs(i - k);
                    int cur = Math.min(diff, (ring.length - diff));
                    res = Math.min(res, cur + dfs(ring, key, dp, k, j + 1));
                }
            }
            dp[i][j] = res + 1;
            return res + 1;
        }

    }

    public class Solution2 {
        public int findRotateSteps(String ring, String key) {
            int n = ring.length();
            int m = key.length();
            int[][] dp = new int[m + 1][n];

            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < n; k++) {
                        if (ring.charAt(k) == key.charAt(i)) {
                            int diff = Math.abs(j - k);
                            int step = Math.min(diff, n - diff);
                            dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                        }
                    }
                }
            }

            return dp[0][0] + m;
        }
    }

    class Solution3 {
        public int findRotateSteps(String ring, String key) {
            char[] ringArr = ring.toCharArray();
            char[] keyArr = key.toCharArray();
            int[][] memo = new int[ringArr.length][keyArr.length];
            return dfs(ringArr, keyArr, 0, 0, memo);
        }

        private int dfs(char[] ring, char[] key, int keyIndex, int ringIndex, int[][] memo) {
            if (keyIndex == key.length)
                return 0;
            if (memo[ringIndex][keyIndex] > 0)
                return memo[ringIndex][keyIndex];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < ring.length; i++) {
                if (ring[i] != key[keyIndex])
                    continue;
                int diff = Math.abs(i - ringIndex);
                int distance = 1 + Math.min(diff, ring.length - diff) + dfs(ring, key, keyIndex + 1, i, memo);
                min = Math.min(min, distance);
            }
            memo[ringIndex][keyIndex] = min;
            return min;
        }
    }
}
