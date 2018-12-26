package src.com.Java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 返回滑动窗口最大值。
 示例:
 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:
 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
*/
public class _239_Sliding_Window_Maximun_滑窗最大值_难 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0)
                return new int[0];
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {
                while ((!dq.isEmpty()) && nums[dq.peekLast()] <= nums[i])//最后一个不是最大值了
                    dq.pollLast();
                dq.offerLast(Integer.valueOf(i));
                while ((!dq.isEmpty()) && (i - dq.peekFirst()) >= k)//个数超出范围了
                    dq.pollFirst();
                if (i - k + 1 >= 0)
                    res[i - k + 1] = nums[dq.peekFirst()];
            }
            return res;
        }
    }
    /*
    For Example: A = [2,1,3,4,6,3,8,9,10,12,56], w=4
        partition the array in blocks of size w=4. The last block may have less then w.
        2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|
        Traverse the list from start to end and calculate max_so_far. Reset max after each block boundary (of w elements).
        left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56
        Similarly calculate max in future by traversing from end to start.
        right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56
        now, sliding max at each position i in current window, sliding-max(i) = max{right_max(i), left_max(i+w-1)}
        sliding_max = 4, 6, 6, 8, 9, 10, 12, 56
     */
    class Solution2 {
        public int[] slidingWindowMax(final int[] in, final int w) {
            final int[] max_left = new int[in.length];
            final int[] max_right = new int[in.length];

            max_left[0] = in[0];
            max_right[in.length - 1] = in[in.length - 1];

            for (int i = 1; i < in.length; i++) {
                max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

                final int j = in.length - i - 1;
                max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
            }

            final int[] sliding_max = new int[in.length - w + 1];
            for (int i = 0, j = 0; i + w <= in.length; i++) {
                sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
            }
            return sliding_max;
        }
    }
}
