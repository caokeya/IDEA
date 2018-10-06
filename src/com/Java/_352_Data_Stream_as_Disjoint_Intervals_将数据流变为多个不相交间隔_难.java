package src.com.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的间隔列表。
例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]

 */
public class _352_Data_Stream_as_Disjoint_Intervals_将数据流变为多个不相交间隔_难 {


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
 
    class SummaryRanges {

        TreeMap<Integer, Interval> tree;

        public SummaryRanges() {
            tree = new TreeMap<>();
        }

        public void addNum(int val) {
            if (tree.containsKey(val))
                return;
            Integer l = tree.lowerKey(val);
            Integer h = tree.higherKey(val);
            if (l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
                tree.get(l).end = tree.get(h).end;
                tree.remove(h);
            } else if (l != null && tree.get(l).end + 1 >= val) {
                tree.get(l).end = Math.max(tree.get(l).end, val);
            } else if (h != null && h == val + 1) {
                tree.put(val, new Interval(val, tree.get(h).end));
                tree.remove(h);
            } else {
                tree.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(tree.values());
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */


}
