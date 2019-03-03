package com.Java;

import java.util.TreeMap;

/*
实现一个 MyCalendar 类来存放你的日程安排，你可以一直添加新的日程安排。
MyCalendar 有一个 book(int start, int end)方法。它意味着在start到end时间内增加一个日程安排，
注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
当 K 个日程安排有一些时间上的交叉时（例如K个日程安排都在同一时间内），就会产生 K 次预订。
每次调用 MyCalendar.book方法时，返回一个整数 K ，表示最大的 K 次预订。
请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
示例 1:
MyCalendarThree();
MyCalendarThree.book(10, 20); // returns 1
MyCalendarThree.book(50, 60); // returns 1
MyCalendarThree.book(10, 40); // returns 2
MyCalendarThree.book(5, 15); // returns 3
MyCalendarThree.book(5, 10); // returns 3
MyCalendarThree.book(25, 55); // returns 3
解释: 
前两个日程安排可以预订并且不相交，所以最大的K次预订是1。
第三个日程安排[10,40]与第一个日程安排相交，最高的K次预订为2。
其余的日程安排的最高K次预订仅为3。
请注意，最后一次日程安排可能会导致局部最高K次预订为2，但答案仍然是3，原因是从开始到最后，时间[10,20]，[10,40]和[5,15]仍然会导致3次预订。
 */
public class _732_My_Calendar_III_我的日程安排表3_难 {
    /*
         利用TreeMap记录时间端点的次数，起点计数+1，终点计数-1。
         每增加一个活动，遍历TreeMap并累加，累计值的最大值即为当前的最大重叠活动次数。
    TreeMap的get操作时间开销为O( log n )，换用keySet+get方式遍历TreeMap会导致TLE。
     */
    class MyCalendarThree {
        TreeMap<Integer, Integer> map;

        public MyCalendarThree() {
            map = new TreeMap<Integer, Integer>();
        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int ans = 0;
            int active = 0;
            for (int i : map.values()) {
                active += i;
                ans = Math.max(ans, active);
            }

            return ans;
        }
    }
    /**
     * Your MyCalendarThree object will be instantiated and called as such:
     * MyCalendarThree obj = new MyCalendarThree();
     * int param_1 = obj.book(start,end);
     */
}
