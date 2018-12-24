package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现三次。找出那个只出现了一次的元素。
示例 1:
输入: [2,2,3,2]
输出: 3
示例 2:
输入: [0,1,0,1,0,1,99]
输出: 99
 */
public class _137_Single_Number_ll_找到只出现了一次的数字2 {
    class Solution {
        public int singleNumber(int[] nums) {

            if (nums.length == 0 || nums == null)
                return -1;
            int res = 0;
            int[] bitmap = new int[32]; // 输入的是整形数组，用bitmap表示的话，最多32位统计每个位置元素出现的个数
            // 统计每个位置元素出现的个数
            for (int i = 0; i < 32; i++) { // 每个位置1的个数
                for (int j = 0; j < nums.length; j++) {
                    bitmap[i] += (nums[j] >> i) & 1; // 将每个位置是1的话移动到最右边。 然后统计1的个数
                }
            }
            // 每个位置对%3 结果移动到对于的i位置，| 运算，就是最后的结果
            for (int i = 0; i < 32; i++) {
                res |= (bitmap[i] % 3) << i;
            }
            return res;
        }
    }

    class Solution2 {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i : nums) {
                int v = map.getOrDefault(i, 0);
                if (v == 2) {
                    map.remove(i);
                } else {
                    map.put(i, v + 1);
                }
            }
            for (int i : map.keySet()) {
                return i;
            }
            return 0;
        }
    }
}
