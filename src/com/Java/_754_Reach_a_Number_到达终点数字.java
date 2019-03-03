package com.Java;

/*
在一根无限长的数轴上，你站在0的位置。终点在target的位置。
每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
返回到达终点需要的最小移动次数。
示例 1:
输入: target = 3
输出: 2
解释:
第一次移动，从 0 到 1 。
第二次移动，从 1 到 3 。
示例 2:
输入: target = 2
输出: 3
解释:
第一次移动，从 0 到 1 。
第二次移动，从 1 到 -1 。
第三次移动，从 -1 到 2 。
 */
public class _754_Reach_a_Number_到达终点数字 {
    /*
     * 求和与目标的差值。目标是消除差异，达到目标。对于第i个移动，如果我们把右移到左边，总和的变化会是2*i少。求和和目标之间的差必须是偶数才能算出来。
     * 如果差值是偶数，我们可以返回当前步骤。 
     * 如果差值为奇数，则需要增加步长，直到差值为偶数为止(最多需要再增加两步)。
     */
    class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int res = 0;
            int sum = 0;
            while (sum < target) {
                res++;
                sum += res;
            }

            while ((sum - target) % 2 != 0) {
                res++;
                sum += res;
            }
            return res;
        }
    }

}
