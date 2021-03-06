package src.com.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
(注：分数越高的选手，排名越靠前。)
示例 1:
输入: [5, 4, 3, 2, 1]
输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 */
public class _506_Relative_Ranks_相对名次 {
    class Solution {
        public String[] findRelativeRanks(int[] nums) {
            int len = nums.length;
            int[] arr = Arrays.copyOf(nums, len);
            Arrays.sort(arr);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(arr[i], len - i);
            }
            String[] res = new String[len];
            for (int i = 0; i < len; i++) {
                int rank = map.get(nums[i]);
                if (rank == 1)
                    res[i] = "Gold Medal";
                else if (rank == 2)
                    res[i] = "Silver Medal";
                else if (rank == 3)
                    res[i] = "Bronze Medal";
                else
                    res[i] = String.valueOf(rank);
            }
            return res;
        }
    }
}
