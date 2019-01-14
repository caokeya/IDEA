package src.com.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
MyCalendar 有一个 book(int start, int end)方法。它意味着在start到end时间内增加一个日程安排，
注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。
否则，返回 false 并且不要将该日程安排添加到日历中。
请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
示例 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(50, 60); // returns true
MyCalendar.book(10, 40); // returns true
MyCalendar.book(5, 15); // returns false
MyCalendar.book(5, 10); // returns true
MyCalendar.book(25, 55); // returns true
解释: 
前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。
第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订。
 */
public class _731_My_Calendar_II_我的日程安排表2 {
    class MyCalendarTwo {
        // 空间O(N)，两两相交
        ArrayList<int[]> overlaps;
        // 空间O(N)，N个不相交的event
        ArrayList<int[]> booked;

        public MyCalendarTwo() {
            overlaps = new ArrayList<>();
            booked = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            // 先判断会不会造成triple booking
            // 时间：O(1)+O(2)+...+O(N)=O(N^2)
            for (int[] overlap : overlaps) {
                if (Math.max(start, overlap[0]) < Math.min(end, overlap[1])) {
                    return false;
                }
            }
            // 如果没有triple booking，说明当前的event是可插入的，则要分别更新overlaps和booked这两个集合.
            // 时间：O(1)+O(2)+...+O(N)=O(N^2)
            for (int[] event : booked) {
                int left = Math.max(start, event[0]);
                int right = Math.min(end, event[1]);
                if (left < right) {
                    overlaps.add(new int[]{left, right});
                }
            }
            booked.add(new int[]{start, end});
            return true;
        }
    }
    /**
     * Your MyCalendarTwo object will be instantiated and called as such:
     * MyCalendarTwo obj = new MyCalendarTwo();
     * boolean param_1 = obj.book(start,end);
     */
}
