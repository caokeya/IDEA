package src.com.Java;

import java.util.PriorityQueue;
import java.util.Queue;

/** 
* @author  suzw
* @version 创建时间：2018年11月7日 上午10:09:24 
* 类说明 
* 
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
进阶:

如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
*/
/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, 
 * there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 * 思路一：使用链表/队列的方式实现，方便插入和排序，但是不便于查找中位数
 * 思路二：https://leetcode.com/problems/find-median-from-data-stream/discuss/74062/Short-simple-JavaC%2B%2BPython-O(log-n)-%2B-O(1)
 * 最大堆small的数量较小一半。
最小堆large有一半的数字。
这使我可以直接访问一个或两个中间值（它们是堆的顶部），因此获得中位数需要O（1）时间。添加一个数字需要O（log n）时间。
 */
public class _295_Finde_Median_From_Data_System_数据流的中位数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class MedianFinder {

    /** initialize your data structure here. */
	private Queue<Integer> large = new PriorityQueue<>();
	private Queue<Integer> small = new PriorityQueue<>();
	
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        large.add(num);				//总是保持着 large.size >= small.size
        small.add(-large.poll());
        if (large.size() < small. size()) {
			large.add(-small.poll());
		}
    }
    
    public double findMedian() {
    	return large.size()>small.size()? large.peek():((double)(large.peek())/2.0+ (double)(-small.peek())/2.0); 
    }
}

