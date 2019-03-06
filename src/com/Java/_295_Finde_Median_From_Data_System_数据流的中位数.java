package src.src.com.Java;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：
    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    double findMedian() - 返回目前所有元素的中位数。
示例：
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
 */
public class _295_Finde_Median_From_Data_System_数据流的中位数 {
    class MedianFinder {
        private PriorityQueue<Integer> right = new PriorityQueue<>();//heap is a minimal heap by default
        private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());//change to a maximum heap

        /*
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        //make sure left.length > right.length
        public void addNum(int num) {
            left.offer(num);
            right.offer(left.poll());
            if (left.size() < right.size()) {
                left.offer(right.poll());
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (double) (left.peek() + right.peek()) / 2;
            }
            return (double) left.peek();
        }
    }
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}

