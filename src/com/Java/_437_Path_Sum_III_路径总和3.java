package src.com.Java;

import java.util.HashMap;
import java.util.Map;

/*
给定一个二叉树，它的每个结点都存放着一个整数值。
找出路径和等于给定数值的路径总数。
路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
示例：
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
返回 3。和等于 8 的路径有:
1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
 */
public class _437_Path_Sum_III_路径总和3 {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> prefixSums = new HashMap<>();
            // the one path above root has sum 0
            prefixSums.put(0, 1);
            return pathSumHelper(root, sum, prefixSums, 0);
        }

        private int pathSumHelper(TreeNode root, int target, Map<Integer, Integer> prefixSums, int sum) {
            if (root == null)
                return 0;
            sum += root.val;
            int res = prefixSums.getOrDefault(sum - target, 0);
            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
            res += pathSumHelper(root.left, target, prefixSums, sum);
            res += pathSumHelper(root.right, target, prefixSums, sum);
            prefixSums.put(sum, prefixSums.get(sum) - 1);
            return res;
        }
    }

    public class Solution2 {
        public int pathSum(TreeNode root, int sum) {
            if (root == null)
                return 0;
            return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int pathSumFrom(TreeNode node, int sum) {
            if (node == null)
                return 0;
            return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val)
                    + pathSumFrom(node.right, sum - node.val);
        }
    }
}
