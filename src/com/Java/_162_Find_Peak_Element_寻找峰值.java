package src.com.Java;
/*
峰值元素是指其值大于左右相邻值的元素。
给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
你可以假设 nums[-1] = nums[n] = -∞。
 */
public class _162_Find_Peak_Element_寻找峰值 {
    class Solution {
        public int findPeakElement(int[] a) {
            int low = 0, mid = 0, high = a.length - 1;
            while (low < high) {
                mid = low + (high - low) / 2;
                if (a[mid] < a[mid + 1])
                    low = mid + 1;
                else
                    high = mid;
            }
            return low;//峰值所在位置
        }
    }
}
