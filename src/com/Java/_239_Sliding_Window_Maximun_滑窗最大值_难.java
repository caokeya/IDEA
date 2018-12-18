package src.com.Java;

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
            if (k <= 0 || nums == null)
                return new int[0];
            int[] output = new int[nums.length - k + 1];
            Deque<Integer> queue = new LinkedList<>(); // stores indices only
            for (int i = 0; i < nums.length; i++) {
                // remove indices from queue which are out of range
                while (!queue.isEmpty() && queue.peek() < i - k + 1)
                    queue.remove();
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                    queue.removeLast();
                queue.add(i);
                if (i >= k - 1)
                    output[i - k + 1] = nums[queue.peek()];
            }
            return output;
        }
    }

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
