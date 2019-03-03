package com.Java;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
注意:
    可以认为区间的终点总是大于它的起点。
    区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:
输入: [ [1,2], [2,3], [3,4], [1,3] ]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class _435_Non_overlapping_Intervals_无重叠区间 {
    /**
     * Definition for an interval.
     */
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class Solution {
        public int eraseOverlapIntervals(Interval[] intervals) {
            if (intervals == null || intervals.length == 0)
                return 0;
            Arrays.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval i1, Interval i2) {
                    return i1.start - i2.start;
                }
            });
            int count = 1;
            int lastEnd = intervals[0].end;
            for (int i = 1; i < intervals.length; i++) {
                Interval currentInterval = intervals[i];
                if (currentInterval.start >= lastEnd) {
                    count++;
                    lastEnd = currentInterval.end;
                } else {
                    lastEnd = Math.min(currentInterval.end, lastEnd);
                }
            }
            return intervals.length - count;
        }
    }
}
