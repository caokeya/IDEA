package src.com.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
示例 1:
输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
示例 2:
输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 */
public class _496_Next_Greater_Element_下一个更大元素 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], i);
            }
            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                int num = nums1[i];
                int index = map.get(num) + 1;
                int nextGreat = -1;
                while (index < nums2.length) {
                    if (num < nums2[index]) {
                        nextGreat = nums2[index];
                        break;
                    }
                    index++;
                }
                result[i] = nextGreat;
            }
            return result;
        }
    }

    class SolutionStack {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
            Stack<Integer> stack = new Stack<>();
            for (int num : nums2) {
                while (!stack.isEmpty() && stack.peek() < num)
                    map.put(stack.pop(), num);
                stack.push(num);
            }
            for (int i = 0; i < nums1.length; i++)
                nums1[i] = map.getOrDefault(nums1[i], -1);
            return nums1;
        }
    }
}
