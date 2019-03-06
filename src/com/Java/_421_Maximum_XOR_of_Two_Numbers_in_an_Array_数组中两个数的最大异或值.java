package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
你能在O(n)的时间解决这个问题吗？
示例:
输入: [3, 10, 5, 25, 2, 8]
输出: 28
解释: 最大的结果是 5 ^ 25 = 28.
 */
public class _421_Maximum_XOR_of_Two_Numbers_in_an_Array_数组中两个数的最大异或值 {
    public class Solution {
        public int findMaximumXOR(int[] nums) {
            int max = 0;
            int mask = 0;
            for (int i = 31; i >= 0; i--) {
                mask = mask | (1 << i); // mask是10000...0
                                        // (32位二进制数)，11000...0，11100...0，11110...0，11111...0，...，11111...1。
                Set<Integer> set = new HashSet<>();
                for (int num : nums) {
                    set.add(num & mask); // 计算nums[]数组中每个数的二进制表示中第i位及其左边的部分表示的数，并将其放入set中。
                }
                int temp = max | (1 << i); // max是nums[]数组中所有任意两个数异或后，二进制表示中第i位左边(不包含第i位)的所有位数所表示的数最大值。
                                           // max是上一轮循环的结果。
                                           // temp是当前可能的最大值，通过下面的for循环验证temp是否满足条件。
                                           // 如果temp不存在，则max为当前最大值，因为temp只比max多了第i位的1。
                for (int prefix : set) {
                    /**
                     * 下面if语句利用了异或(^)的性质：如果 a ^ b = c，则 b ^ c = a。
                     * 其中a和b都是set中的任意两个数(即nums[]数组中每个数的二进制表示中第i位及其左边的部分表示的数)，c是当前可能得最大值temp。
                     * 如果满足if条件，则set中存在两个二进制表示中前i位prefix数，在异或后可以得到temp。
                     */
                    if (set.contains(temp ^ prefix)) {
                        max = temp;
                        break;
                    }
                }
            }
            return max;
        }
    }

    class Solution2 {
        public int findMaximumXOR(int[] nums) {
            if (nums == null || nums.length <= 1)
                return 0;

            int max = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int xor = (nums[i] ^ nums[j]);
                    if (xor > max) {
                        max = xor;
                    }
                }
            }

            return max;
        }
    }

    class Solution3 {
        public int findMaximumXOR(int[] nums) {
            TrieNode root = new TrieNode(0);
            TrieNode curr = root;
            for (int n : nums) {
                for (int i = 31; i >= 0; i--) {
                    int temp = n & (1 << i);
                    if (temp == 0) {
                        if (curr.right == null) {
                            curr.right = new TrieNode(0);
                        }
                        curr = curr.right;
                    } else {
                        if (curr.left == null) {
                            curr.left = new TrieNode(1);
                        }
                        curr = curr.left;
                    }
                }
                curr = root;
            }
            int res = 0;
            for (int n : nums) {
                int subres = 0;
                for (int i = 31; i >= 0; i--) {
                    int temp = n & (1 << i);
                    if (curr.left != null && curr.right != null) {
                        if (temp == 0) {
                            curr = curr.left;
                        } else
                            curr = curr.right;
                    } else {
                        curr = curr.left != null ? curr.left : curr.right;
                    }
                    subres += temp ^ (curr.val << i);
                }
                res = Math.max(res, subres);
                curr = root;
            }
            return res;
        }
    }

    class TrieNode {
        int val;
        TrieNode left;
        TrieNode right;

        public TrieNode(int v) {
            this.val = v;
            left = null;
            right = null;
        }
    }
}
