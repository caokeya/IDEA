package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
在一个0和1的数组A中，有多少非空的子数组有和S?
Example 1:
Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation: 
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
 */
public class _930_Binary_Subarrays_With_Sum_带和的二进制子数组 {
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
