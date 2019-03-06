package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
示例：
输入：A = [1,0,1,0,1], S = 2
输出：4
解释：
如下面黑体所示，有 4 个满足题目要求的子数组：
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
 */
public class _930_Binary_Subarrays_With_Sum_和相同的二元子数组 {
    class Solution {
        public int numSubarraysWithSum(int[] A, int S) {
            Map<Integer, Integer> c = new HashMap<>();
            c.put(0, 1);
            int psum = 0, res = 0;
            for (int i : A) {
                psum += i;
                res += c.getOrDefault(psum - S, 0);
                c.put(psum, c.getOrDefault(psum, 0) + 1);
            }
            return res;
        }
    }
}
