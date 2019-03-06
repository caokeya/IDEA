package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
示例 1 :
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class _560_Subarray_Sum_Equals_K_和为K的子数组 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            //我们知道解决这个问题的关键是求和[i, j]。因此，如果我们知道SUM[0, i - 1]和SUM[0, j]，
            //那么我们可以很容易地得到SUM[i, j]。为了实现这一点，我们只需要遍历数组，计算当前和，
            //并将所有看到的PreSum的数量保存到HashMap中。时间复杂度O(n)，空间复杂度O(n)。
            /*
             * if sum[i]−sum[j]=ksum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices iii and jjj is kkk.
             * Based on these thoughts, we make use of a hashmap mapmapmap 
             * which is used to store the cumulative sum upto all the indices possible along with 
             * the number of times the same sum occurs. We store the data in the form:
             * (sumi,no.ofoccurencesofsumi)(sum_i, no. of occurences ofsum_i)(sumi​,no.ofoccurencesofsumi​).
             */
            int sum = 0, count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
