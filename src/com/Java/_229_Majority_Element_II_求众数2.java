package src.com.Java;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

/*
给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
示例 1:
输入: [3,2,3]
输出: [3]
示例 2:
输入: [1,1,1,3,3,2,2,2]
输出: [1,2]
*/
public class _229_Majority_Element_II_求众数2 {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {

            int num1 = 0;
            int num2 = 0;

            int count1 = 0;
            int count2 = 0;

            for (int i : nums) {

                if (num1 == i) {
                    count1++;
                } else if (num2 == i) {
                    count2++;
                } else if (count1 == 0) {
                    num1 = i;
                    count1++;
                } else if (count2 == 0) {
                    num2 = i;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }

            }

            count1 = 0;
            count2 = 0;

            for (int i : nums) {
                if (num1 == i)
                    count1++;
                else if (num2 == i)
                    count2++;
            }
            List<Integer> result = new LinkedList();

            if (count1 > nums.length / 3)
                result.add(num1);

            if (count2 > nums.length / 3)
                result.add(num2);

            return result;
        }
    }
}