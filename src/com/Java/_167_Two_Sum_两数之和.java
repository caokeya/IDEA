package src.com.Java;

/*
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
说明:
    返回的下标值（index1 和 index2）不是从零开始的。
    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class _167_Two_Sum_两数之和 {
    class Solution {
        public int[] twoSum(int[] num, int target) {
            int[] indice = new int[2];
            if (num == null || num.length < 2)
                return indice;
            int left = 0, right = num.length - 1;
            while (left < right) {
                int v = num[left] + num[right];
                if (v == target) {
                    indice[0] = left + 1;
                    indice[1] = right + 1;
                    break;
                } else if (v > target) {
                    right--;
                } else {
                    left++;
                }
            }
            return indice;
        }
    }
}
