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
    /*
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
            Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
            preSum.put(0, 1);
            return pathSumRecur(preSum, 0, sum, root);
        }

        private int pathSumRecur(Map<Integer, Integer> preSum, int currSum, int target, TreeNode node) {
            if (node == null)
                return 0;
            currSum += node.val;
            //In a prefix sum array, sum(a,b) = sum(0, b) - sum(0, a-1) is the same as sum(0, a-1) = sum(0, b) - sum(a,b)
            // where currSum = sum(0, b) and target is sum(a,b). a and b are indices in the array.
            //Note that currSum is the prefix sum, i.e. the sum of all node values (from its ancestors to that node).
            int res = preSum.getOrDefault(currSum - target, 0);//See if there is a subarray sum equals to target
            //for example, if we have currSum=8 and target=6,
            //we want to see whether we can cut some head nodes whose prefix is currSum-target=2,
            //then we get a wanted path which is from that node's child to the current node.
            preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
            //Extend to left and right child
            res += pathSumRecur(preSum, currSum, target, node.left) + pathSumRecur(preSum, currSum, target, node.right);
            preSum.put(currSum, preSum.get(currSum) - 1);//Remove the current node so it won't affect other path
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
            return (node.val == sum ? 1 : 0) +
                    pathSumFrom(node.left, sum - node.val) +
                    pathSumFrom(node.right, sum - node.val);
        }
    }
}
