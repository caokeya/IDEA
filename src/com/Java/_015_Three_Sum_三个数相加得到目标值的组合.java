package src.com.Java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三个数相加得到目标值的组合

public class _015_Three_Sum_三个数相加得到目标值的组合 {
	
	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(nums);
			for (int i = 0; i + 2 < nums.length; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
					continue;
				}
				int j = i + 1, k = nums.length - 1;
				int target = -nums[i];
				while (j < k) {
					if (nums[j] + nums[k] == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[k]));
						j++;
						k--;
						while (j < k && nums[j] == nums[j - 1])
							j++; // skip same result
						while (j < k && nums[k] == nums[k + 1])
							k--; // skip same result
					} else if (nums[j] + nums[k] > target) {
						k--;
					} else {
						j++;
					}
				}
			}
			return res;
		}
	}
	
}
