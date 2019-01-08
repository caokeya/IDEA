package src.com.Java;

/*
给定一组含有正整数和负整数的数组。如果某个索引中的 n 是正数的，则向前移动 n 个索引。相反，如果是负数(-n)，则向后移动 n 个索引。
假设数组首尾相接。判断数组中是否有环。环中至少包含 2 个元素。环中的元素一律“向前”或者一律“向后”。
示例 1：给定数组 [2, -1, 1, 2, 2], 有一个循环，从索引 0 -> 2 -> 3 -> 0。
示例 2：给定数组[-1, 2], 没有循环。
 */
public class _457_Circular_Array_Loop_环形数组循环 {
    public class Solution {
        public boolean circularArrayLoop(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                // slow/fast pointer
                int j = i, k = getIndex(i, nums);
                while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
                    if (j == k) {
                        // check for loop with only one element
                        if (j == getIndex(j, nums)) {
                            break;
                        }
                        return true;
                    }
                    j = getIndex(j, nums);
                    k = getIndex(getIndex(k, nums), nums);
                }
                // loop not found, set all element along the way to 0
                j = i;
                int val = nums[i];
                while (nums[j] * val > 0) {
                    int next = getIndex(j, nums);
                    nums[j] = 0;
                    j = next;
                }
            }
            return false;
        }

        public int getIndex(int i, int[] nums) {
            int n = nums.length;
            return i + nums[i] >= 0 ? (i + nums[i]) % n : n + ((i + nums[i]) % n);
        }
    }
}
