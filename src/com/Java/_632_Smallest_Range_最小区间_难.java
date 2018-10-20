package src.com.Java;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
示例 1:
输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出: [20,24]
解释: 
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 */
public class _632_Smallest_Range_最小区间_难 {
    /*
         * 从每个数组中取出一个放到一个最小堆，用一个范围包括这些数字不就是一个合理的range了
         * 每次就从抽出来的数中拿出最小的那个数，然后再加入在那个数组里面后面的那个数 
         * 当加不了时就结束了，在这个过程中收集range最小的答案
     */
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int max = nums.get(0).get(0);
            for (int i = 0; i < nums.size(); i++) {
                minHeap.add(new int[] { nums.get(i).get(0), i, 0 });
                max = Math.max(max, nums.get(i).get(0));
            }

            int minRange = Integer.MAX_VALUE;
            int start = -1;
            while (minHeap.size() == nums.size()) {
                int[] t = minHeap.poll();
                if (max - t[0] < minRange) {
                    minRange = max - t[0];
                    start = t[0];
                }

                if (t[2] + 1 < nums.get(t[1]).size()) {
                    t[0] = nums.get(t[1]).get(t[2] + 1);
                    t[2]++;
                    minHeap.add(t);
                    max = Math.max(max, t[0]);
                }
            }

            return new int[] { start, start + minRange };
        }
    }
}
