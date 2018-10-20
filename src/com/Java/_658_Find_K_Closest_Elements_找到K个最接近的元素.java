package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
示例 1:
输入: [1,2,3,4,5], k=4, x=3
输出: [1,2,3,4]
示例 2:
输入: [1,2,3,4,5], k=4, x=-1
输出: [1,2,3,4]
 */
public class _658_Find_K_Closest_Elements_找到K个最接近的元素 {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res = new ArrayList<>();
            int l = 0, r = arr.length - k;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            for (int i = l; i < l + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
}
