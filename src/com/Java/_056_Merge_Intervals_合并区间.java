package com.Java;

import java.util.LinkedList;
import java.util.List;
/*
给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class _056_Merge_Intervals_合并区间 {
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
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() <= 1)
                return intervals;

            // Sort by ascending starting point using an anonymous Comparator
            intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

            List<Interval> result = new LinkedList<Interval>();
            int start = intervals.get(0).start;
            int end = intervals.get(0).end;

            for (Interval interval : intervals) {
                if (interval.start <= end) // Overlapping intervals, move the end if needed
                    end = Math.max(end, interval.end);
                else { // Disjoint intervals, add the previous one and reset bounds
                    result.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }

            // Add the last interval
            result.add(new Interval(start, end));
            return result;
        }
    }
}
