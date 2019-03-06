package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
 */
public class _347_Top_K_Frequent_Elements_前K个高频元素 {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {

            List<Integer>[] bucket = new List[nums.length + 1];
            Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

            for (int n : nums) {
                frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
            }

            for (int key : frequencyMap.keySet()) {
                int frequency = frequencyMap.get(key);
                if (bucket[frequency] == null) {
                    bucket[frequency] = new ArrayList<>();
                }
                bucket[frequency].add(key);
            }

            List<Integer> res = new ArrayList<>();

            for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
                if (bucket[pos] != null) {
                    res.addAll(bucket[pos]);
                }
            }
            return res;
        }
    }
}
