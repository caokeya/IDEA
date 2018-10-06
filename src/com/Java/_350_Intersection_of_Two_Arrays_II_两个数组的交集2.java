package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;

/*
给定两个数组，编写一个函数来计算它们的交集。
示例 1:
输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
说明：
    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    我们可以不考虑输出结果的顺序。
 */
public class _350_Intersection_of_Two_Arrays_II_两个数组的交集2 {
    public class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < nums1.length; i++) {
                if (map.containsKey(nums1[i]))
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                else
                    map.put(nums1[i], 1);
            }

            for (int i = 0; i < nums2.length; i++) {
                if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                    result.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }

            int[] r = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                r[i] = result.get(i);
            }

            return r;
        }
    }
}
