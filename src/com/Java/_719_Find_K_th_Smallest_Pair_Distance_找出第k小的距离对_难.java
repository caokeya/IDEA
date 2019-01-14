package src.com.Java;

import java.util.Arrays;

/*
给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
示例 1:
输入：
nums = [1,3,1]
k = 1
输出：0 
解释：
所有数对如下：
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 */
public class _719_Find_K_th_Smallest_Pair_Distance_找出第k小的距离对_难 {
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            // Initiate low and high as a range of numbers
            int low = 0;
            int high = nums[nums.length - 1] - nums[0];
            while (low < high) {
                // Get size of windows which will be using for search
                int mid = (high + low) / 2;
                int j = 0;
                int count = 0;
                for (int i = 0; i < nums.length; i++) {
                    // Increase window till range of numbers is less then defined numbers interval(mid)
                    while (j < nums.length && (nums[j] - nums[i] <= mid))
                        j++;
                    // Count number of elements between i, j and increase count
                    count += j - i - 1;
                }
                if (count >= k)
                    high = mid; // Too much distances for selected value of window (mid); decrease mid
                else
                    low = mid + 1; // Not enough differences between pairs for select
            }
            return low;
        }
    }
}
