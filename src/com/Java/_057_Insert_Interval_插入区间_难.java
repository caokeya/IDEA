package src.com.Java;

import java.util.ArrayList;
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

    class Solution2 {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> r = new ArrayList<>();
            if (intervals == null || intervals.isEmpty()) {
                r.add(newInterval);
                return r;
            }
            if (newInterval.end < intervals.get(0).start) {
                r.add(newInterval);
                for (Interval i : intervals) r.add(i);
                return r;
            }
            if (newInterval.start > intervals.get(intervals.size() - 1).end) {
                for (Interval i : intervals) r.add(i);
                r.add(newInterval);
                return r;
            }
            // Given the current interval and newInterval, here are cases to consider
            // newInterval and current interval doesn't overlap =>
            // (1) newInterval is after current,
            // (2) newInterval is before current.  Otherwise they overlap
            // if case (1) then add current and continue
            // if case (2) then add newInterval, then current (in that order).
            // If neither cases (1) and (2) this is an overlap situation.
            //  For overlap - set start = Min(current.start, newInteval.start)
            //  end = Max(current.end, newInterval.end).
            //  Then loop through remaining and expand the end as necessary.
            //  Once we no longer determine it overlaps, we can add the new interval(start, end) to result and break out of the loop.
            //  Fill the result with the remaining intervals (they have to be disjointed)
            int i = 0;
            while (i < intervals.size()) {
                Interval current = intervals.get(i);
                if (newInterval.start > current.end) {
                    r.add(current);
                    i++;
                    continue;
                }
                if (newInterval.end < current.start) {
                    r.add(newInterval);
                    r.add(current);
                    i++;
                    break;
                }
                // overlap
                int min = Math.min(current.start, newInterval.start);
                int max = Math.max(current.end, newInterval.end);
                i++;
                while (i < intervals.size() && intervals.get(i).start <= max) {
                    max = Math.max(max, intervals.get(i).end);
                    i++;
                }
                r.add(new Interval(min, max));
                break;
            }
            while (i < intervals.size()) {
                r.add(intervals.get(i));
                i++;
            }
            return r;
        }
    }
}
