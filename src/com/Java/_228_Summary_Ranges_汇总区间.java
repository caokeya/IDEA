package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 示例 1:
 输入: [0,1,2,4,5,7]
 输出: ["0->2","4->5","7"]
 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 示例 2:
 输入: [0,2,3,4,6,8,9]
 输出: ["0","2->4","6","8->9"]
 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
public class _228_Summary_Ranges_汇总区间 {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            for (int slow = 0, fast = 0; fast < nums.length; fast++) {
                while (fast + 1 < nums.length && nums[fast] == nums[fast + 1] - 1) {
                    fast++;
                }
                if (fast == slow) {
                    res.add(nums[fast] + "");
                } else {
                    res.add(nums[slow] + "->" + nums[fast]);
                }
                slow = fast + 1;
            }
            return res;
        }
    }
}
