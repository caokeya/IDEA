package src.com.Java;

/*
给定一组含有正整数和负整数的数组。如果某个索引中的 n 是正数的，则向前移动 n 个索引。相反，如果是负数(-n)，则向后移动 n 个索引。
假设数组首尾相接。判断数组中是否有环。环中至少包含 2 个元素。环中的元素一律“向前”或者一律“向后”。
示例 1：给定数组 [2, -1, 1, 2, 2], 有一个循环，从索引 0 -> 2 -> 3 -> 0。
示例 2：给定数组[-1, 2], 没有循环。
 */
public class _457_Circular_Array_Loop_环形数组循环 {
    class Solution {
        public boolean circularArrayLoop(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                Integer ps = i;
                Integer pf = next(nums, 0, i);
                int dir = nums[i];
                while (ps != null && pf != null && ps != pf) {
                    ps = next(nums, dir, ps);
                    pf = next(nums, dir, next(nums, dir, pf));
                }
                if (ps != null && ps == pf) {
                    return true;
                }
            }
            return false;
        }

        Integer next(int[] nums, int dir, Integer pos) {
            if (pos == null)
                return null;
            if (dir * nums[pos] < 0)
                return null;
            Integer next = pos + nums[pos];
            if (next >= nums.length)
                next = next % nums.length;
            if (next < 0)
                next += nums.length;
            if (next == pos)
                next = null;
            return next;
        }
    }
}
