package src.com.Java;
/*
你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。）
你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。
当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。
当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。  (当前所处位置不变。)
例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。
现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。
示例 1:
输入: 
target = 3
输出: 2
解释: 
最短指令列表为 "AA"
位置变化为 0->1->3
示例 2:
输入: 
target = 6
输出: 5
解释: 
最短指令列表为 "AAARA"
位置变化为 0->1->3->7->7->6
 */
public class _818_Race_Car_赛车_难 {
    class Solution {
        public int racecar(int target) {
             // target是position，或者为了好理解，target表示lane number。
             // 因为题目要求position是从0开始算起，所以在这道题里，target要当做index来看待。
             // dp[i]表示到达position i需要的最少步数。
            int[] dp = new int[target + 1];
            return helper(dp, target);
        }
     
        private int helper(int[] dp, int target) {
            if (dp[target] > 0) {
                return dp[target];
            }
             
            // x = log2(n) (log以2为底n)，该等式意思是：2的x次方等于n (即Math.pow(2, x) == n)。
            // loga(b) == logc(b) / logc(a)：log以a为底的b = log以c为底的b / log以c为底的a。

            // java里Math.log(n)表示：log以e为底的n，意思是e的多少次方等于n。

            // n表示从0开始，一直向右加速('A')，第一次到达或超过当前position target，需要多少步 (即从0开始要连续多少个'A'才能到达或超过target)。
            // 因为target相当于index，所以要加1后再计算。
            
            // 举例：
            // 如果target = 4，则0 --> 1 --> 3 --> 7，需要三个'A'。
            // (int) Math.ceil(Math.log(4) / Math.log(2)) = 2；
            // (int) Math.ceil(Math.log(4 + 1) / Math.log(2)) = 3。
            int n = (int) Math.ceil(Math.log(target + 1) / Math.log(2));
            if ((1 << n) == target + 1) { // 如果连续加速n步后等于position i，而并没有超过它，这是最好情形。
                dp[target] = n;
            } else { 
                // 否则我们要考虑两种情况，步数少的就是dp[target]的值：
                //     1. 超过position target，到达紧挨着target右边的加速点后，再掉头返回到target的总步数。
                //     2. 没到position target，到达紧挨着target左边的加速点后，掉头返回加速走i步，再掉头加速走到position target的总步数。
             
                // 第一种情况：
                // (1 << n) - (target + 1)是连续加速走n步后比position target超过的长度。
                // 长度 - 长度 = index。
                // n表示从0开始连续加速n步，1表示掉头操作。
                dp[target] = helper(dp, (1 << n) - (target + 1)) + n + 1;
             
                // 第二种情况：
                // i是到达紧挨着target左边的加速点后 (此时走了n - 1步)，再掉头返回走i步 (i的取值范围是[0, n - 1)，0表示掉头再掉头，
                // 把速度降为1。n - 1表示往回最多可以走小于n - 1步，因为刚刚只加速走了n - 1步，如果往回走n - 1步等于回到原点，没意义。)。
                // target - (1 << (n - 1)) + (1 << i)表示从往回走i步后停下来的position到position target的长度。
                for (int i = 0; i < n - 1; i++) {
                    dp[target] = Math.min(dp[target], helper(dp, target - (1 << (n - 1)) + (1 << i)) + n + i + 1);
                }
            }
            return dp[target];
        }
    }
}
