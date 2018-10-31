package src.com.Java;

/*
给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
    left 中的每个元素都小于或等于 right 中的每个元素。
    left 和 right 都是非空的。
    left 要尽可能小。
在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
示例 1：
输入：[5,0,3,8,6]
输出：3
解释：left = [5,0,3]，right = [8,6]
示例 2：
输入：[1,1,1,0,6,12]
输出：4
解释：left = [1,1,1,0]，right = [6,12]
 */
public class _915_Partition_Array_into_Disjoint_Intervals_分割数组 {
    class Solution {
        public int partitionDisjoint(int[] A) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            int[] leftMax = new int[A.length];
            int[] rightMin = new int[A.length];
            
            for (int i = 0; i < A.length; i++) {
                max = Math.max(max, A[i]);
                leftMax[i] = max;
            }
            
            for (int i = A.length - 1; i >= 0; i--) {
                min = Math.min(min, A[i]);
                rightMin[i] = min;
            }
            
            for (int i = 0; i < A.length - 1; i++) {
                if (leftMax[i] <= rightMin[i + 1]) {
                    return i + 1;
                }
            }
            
            return -1;
        }
    }
}
