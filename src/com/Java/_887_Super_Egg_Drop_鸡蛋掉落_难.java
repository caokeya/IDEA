package com.Java;

/*
你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
你的目标是确切地知道 F 的值是多少。
无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
示例 1：
输入：K = 1, N = 2
输出：2
解释：
鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
如果它没碎，那么我们肯定知道 F = 2 。
因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
示例 2：
输入：K = 2, N = 6
输出：3
示例 3：
输入：K = 3, N = 14
输出：4
 */
public class _887_Super_Egg_Drop_鸡蛋掉落_难 {
    /*
            * 假设我们有k个鸡蛋第m步时，在第X层扔鸡蛋。这时候，会有两种结果，鸡蛋碎了，或者没碎。 
            * 如果鸡蛋没碎，我们接下来会在更高的楼层扔，最多能确定 X + dp[k][m-1] 层的结果； 
            * 如果鸡蛋碎了，我们接下来会在更低的楼层扔，最多能确定 Y + dp[k-1][m-1] 层的结果(假设在第X层上还有Y层)。 
            * 因此，这次扔鸡蛋，我们最多能测出 dp[k-1][m-1] (摔碎时能确定的层数) + dp[k][m-1](没摔碎时能确定的层数) + 1 (本层) 层的结果。 
            * 另外，我们知道一个鸡蛋一次只能测一层，没有鸡蛋一层都不能测出来。 因此我们可以列出完整的递推式:
     * dp[k][0] = 0 
     * dp[1][m] = m (m > 0) 
     * dp[k][m] = dp[k-1][m-1] + dp[k][m-1] + 1 (k > 0, m>0)
     */
    class Solution {
        public int superEggDrop(int KEggs, int NFloors) {
            int dp[] = new int[KEggs + 1];

            int moves = 0;
            for (moves = 0; dp[KEggs] < NFloors; ++moves) {

                for (int k = KEggs; k > 0; --k)
                    dp[k] += dp[k - 1] + 1;
            }

            return moves;
        }

        public int superEggDropV1(int KEggs, int NFloors) {
            int[][] dp = new int[NFloors + 1][KEggs + 1];

            int moves = 0;
            while (dp[moves][KEggs] < NFloors) {
                moves++;

                for (int eggCnt = 1; eggCnt <= KEggs; ++eggCnt)
                    // 即当前情况=丢下去碎了，消耗一步能确定的层数+丢下去没碎，消耗一步能确定的层数+当前这一层
                    dp[moves][eggCnt] = dp[moves - 1][eggCnt - 1] + dp[moves - 1][eggCnt] + 1;
            }

            return moves;
        }
    }
}
