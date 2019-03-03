package com.Java;

/*
现有一个房间，墙上挂有 n 只已经打开的灯泡和 4 个按钮。在进行了 m 次未知操作后，你需要返回这 n 只灯泡可能有多少种不同的状态。
假设这 n 只灯泡被编号为 [1, 2, 3 ..., n]，这 4 个按钮的功能如下：
    将所有灯泡的状态反转（即开变为关，关变为开）
    将编号为偶数的灯泡的状态反转
    将编号为奇数的灯泡的状态反转
    将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)
示例 1:
输入: n = 1, m = 1.
输出: 2
说明: 状态为: [开], [关]
示例 2:
输入: n = 2, m = 1.
输出: 3
说明: 状态为: [开, 关], [关, 开], [关, 关]
示例 3:
输入: n = 3, m = 1.
输出: 4
说明: 状态为: [关, 开, 关], [开, 关, 开], [关, 关, 关], [关, 开, 开].
 */
public class _672_Bulb_Switcher_II_灯泡开关2 {
    /*
     * If we use button 1 and 2, it equals to use button 3.
     * 
     * Similarly...
     * 
     * 1 + 2 --> 3, 1 + 3 --> 2, 2 + 3 --> 1 
     * So, there are only 8 cases.
     * 
     * All_on, 1, 2, 3, 4, 1+4, 2+4, 3+4
     * 
     * And we can get all the cases, when n>2 and m>=3.
     */
    class Solution {
        public int flipLights(int n, int m) {
            if (m == 0)
                return 1;
            if (n == 1)
                return 2;
            if (n == 2 && m == 1)
                return 3;
            if (n == 2)
                return 4;
            if (m == 1)
                return 4;//For all n>=3&m==1, return 4   1 2 3 4
            if (m == 2)
                return 7;//For all n>=3&m==2, return 7   all_on 1 2 3 1+4 2+4 3+4 (except only 4)
            if (m >= 3)
                return 8;//for all n>=3, m>=3, have all_on 1 2 3 4 1+4 2+4 3+4 
                         //in total 8 possible states(rule 1. doing twice of 1/2/3/4 will cancle the effect ; 
                         //rule 2. 1+2->3; 1+3->2 2+3->1, thus 1&2, 1&3, 2&3 can not co-occur with each other)
            return 8;
        }
    }

}
