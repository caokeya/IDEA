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
            List<String> ranges = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                // begin range;
                int beginIndex = i;
                if (i == nums.length - 1) {
                    ranges.add("" + nums[beginIndex]);
                    break;
                }
                while (i + 1 < nums.length && (nums[i + 1] == nums[i] + 1)) {
                    // in the same range.
                    i++;
                    if (i == nums.length - 1)
                        break; // reached the end
                }
                if (beginIndex == i) {
                    ranges.add("" + nums[beginIndex]);
                } else {
                    ranges.add(nums[beginIndex] + "->" + nums[i]);
                }
            }

            return ranges;
        }
    }
}
