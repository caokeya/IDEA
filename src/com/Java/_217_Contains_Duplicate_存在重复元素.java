package src.com.Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 给定一个整数数组，判断是否存在重复元素。
 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 示例 1:
 输入: [1,2,3,1]
 输出: true
 示例 2:
 输入: [1,2,3,4]
 输出: false
 示例 3:
 输入: [1,1,1,3,3,4,3,2,4,2]
 输出: true
 */
public class _217_Contains_Duplicate_存在重复元素 {
    class Solution {
        public boolean containsDuplicate(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int x : arr) {
                if (set.contains(x))
                    return true;
                set.add(x);
            }
            return false;
        }
    }
}
