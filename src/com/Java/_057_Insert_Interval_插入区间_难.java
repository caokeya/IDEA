package src.com.Java;

import java.util.LinkedList;
import java.util.List;
/*
给出一个无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
示例 1:
输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]
 */
public class _057_Insert_Interval_插入区间_难 {
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
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> result = new LinkedList<>();
            int i = 0;
            // add all the intervals ending before newInterval starts
            while (i < intervals.size() && intervals.get(i).end < newInterval.start)
                result.add(intervals.get(i++));
            // merge all overlapping intervals to one considering newInterval
            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval = new Interval( // we could mutate newInterval here also
                        Math.min(newInterval.start, intervals.get(i).start),
                        Math.max(newInterval.end, intervals.get(i).end));
                i++;
            }
            result.add(newInterval); // add the union of intervals we got
            // add all the rest
            while (i < intervals.size())
                result.add(intervals.get(i++));
            return result;
        }
    }
}
