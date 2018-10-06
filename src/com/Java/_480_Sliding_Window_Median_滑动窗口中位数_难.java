package src.com.Java;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
例如：
[2,3,4]，中位数是 3
[2,3]，中位数是 (2 + 3) / 2 = 2.5
给出一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口移动 1 位。
你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
例如：
给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
窗口位置                      中位数
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 */
public class _480_Sliding_Window_Median_滑动窗口中位数_难 {
    public class Solution {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });

        public double[] medianSlidingWindow(int[] nums, int k) {
            int n = nums.length - k + 1;
            if (n <= 0)
                return new double[0];
            double[] result = new double[n];

            for (int i = 0; i <= nums.length; i++) {
                if (i >= k) {
                    result[i - k] = getMedian();
                    remove(nums[i - k]);
                }
                if (i < nums.length) {
                    add(nums[i]);
                }
            }

            return result;
        }

        private void add(int num) {
            if (num < getMedian()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }

        private void remove(int num) {
            if (num < getMedian()) {
                maxHeap.remove(num);
            } else {
                minHeap.remove(num);
            }
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }

        private double getMedian() {
            if (maxHeap.isEmpty() && minHeap.isEmpty())
                return 0;

            if (maxHeap.size() == minHeap.size()) {
                return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
            } else {
                return (double) minHeap.peek();
            }
        }
    }
}
