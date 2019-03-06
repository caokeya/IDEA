package src.src.com.Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 示例 1:
 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:
 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
*/
public class _215_Kth_Largest_Element_in_an_Array_数组中的第K个最大元素 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int pos = nums.length - k;
            helper(nums, 0, nums.length - 1, pos);
            return nums[pos];
        }

        private void helper(int[] nums, int i, int j, int pos) {
            if (i >= j) {
                return;
            }
            int x = nums[i + (j - i) / 2];
            int start = i, end = j;
            while (start <= end) {
                while (nums[start] < x) {
                    start++;
                }
                while (nums[end] > x) {
                    end--;
                }
                if (start <= end) {
                    int temp = nums[start];
                    nums[start++] = nums[end];
                    nums[end--] = temp;
                }
            }
            if (start - 1 >= pos) {
                helper(nums, i, start - 1, pos);
            } else {
                helper(nums, start, j, pos);
            }
        }
    }

    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            });
            for (int i = 0; i < k; i++) {
                pq.add(nums[i]);
            }

            for (int i = k; i < nums.length; i++) {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
            return (pq.peek());
        }
    }

    class Solution3 {
        public int findKthLargest2(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
}
