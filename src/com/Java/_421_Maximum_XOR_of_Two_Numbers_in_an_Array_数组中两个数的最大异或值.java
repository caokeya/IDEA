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
    class Solution {
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

    class Solution2 {
        public int findMaximumXOR(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // Init Trie.
            Trie root = new Trie();
            for (int num : nums) {
                Trie curNode = root;
                for (int i = 31; i >= 0; i--) {
                    int curBit = (num >>> i) & 1;
                    if (curNode.children[curBit] == null) {
                        curNode.children[curBit] = new Trie();
                    }
                    curNode = curNode.children[curBit];
                }
            }
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                Trie curNode = root;
                int curSum = 0;
                for (int i = 31; i >= 0; i--) {
                    int curBit = (num >>> i) & 1;
                    if (curNode.children[curBit ^ 1] != null) {
                        curSum += (1 << i);
                        curNode = curNode.children[curBit ^ 1];
                    } else {
                        curNode = curNode.children[curBit];
                    }
                }
                max = Math.max(curSum, max);
            }
            return max;
        }
    }
    class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[2];
        }
    }
}
