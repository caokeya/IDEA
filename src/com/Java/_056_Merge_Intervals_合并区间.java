package src.com.Java;

import java.util.*;

/*
给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class _056_Merge_Intervals_合并区间 {
    /*
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
            List<Interval> result = new ArrayList<>();
            if (intervals == null || intervals.size() < 1) {
                return result;
            }
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval a, Interval b) {
                    if (a.start == b.start) {
                        return a.end - b.end;
                    }
                    return a.start - b.start;
                }
            });
            int start = intervals.get(0).start;
            int end = intervals.get(0).end;
            for (int i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).start) {
                    end = Math.max(end, intervals.get(i).end);
                } else {
                    result.add(new Interval(start, end));
                    start = intervals.get(i).start;
                    end = intervals.get(i).end;
                }
            }
            result.add(new Interval(start, end));
            return result;
        }
    }
}
