package com.Java;

import java.util.List;

/*
给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
示例 1：
输入: ["23:59","00:00"]
输出: 1
 */
public class _539_Minimum_Time_Difference_最小时间差 {
    class Solution {
        // There is only 24 * 60 = 1440 possible time points. Just create a boolean array, 
        //each element stands for if we see that time point or not.
        public int findMinDifference(List<String> timePoints) {
            boolean[] bool = new boolean[24 * 60];
            for (String point : timePoints) {
                String[] time = point.split(":");
                int m = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                if (bool[m])
                    return 0;
                bool[m] = true;
            }

            int pre = -24 * 60, res = 24 * 60;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < 24 * 60; i++) {
                if (bool[i]) {
                    res = Math.min(i - pre, res);//不过零点的最小时间差
                    max = Math.max(i, max);//最大时间
                    min = Math.min(i, min);//最小时间
                    pre = i;//记录当前时间
                }
            }
            res = Math.min(min + 24 * 60 - max, res);//过零点的最小时间差和不过零点的最小时间差
            return res;
        }
    }
}
