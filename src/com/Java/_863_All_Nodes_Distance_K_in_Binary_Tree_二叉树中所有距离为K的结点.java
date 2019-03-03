package com.Java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
示例 1：
输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
输出：[7,4,1]
解释：
所求结点为与目标结点（值为 5）距离为 2 的结点，
值分别为 7，4，以及 1
注意，输入的 "root" 和 "target" 实际上是树上的结点。
上面的输入仅仅是对这些对象进行了序列化描述。
 */
public class _863_All_Nodes_Distance_K_in_Binary_Tree_二叉树中所有距离为K的结点 {
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

        Map<TreeNode, Integer> distanceMap = new HashMap<>(); // key 节点 value 节点到target的距离

        /**
         * 找到目标节点，返回的是到目标节点的距离
         */
        private int findTarget(TreeNode node, TreeNode target) {
            if (node == null) {
                return -1;
            }
            if (node == target) {
                distanceMap.put(node, 0);
                return 0;
            }
            int leftDistance = findTarget(node.left, target);
            if (leftDistance >= 0) {
                distanceMap.put(node, leftDistance + 1);
                return leftDistance + 1;
            } else {
                int rightDistance = findTarget(node.right, target);
                if (rightDistance >= 0) {
                    distanceMap.put(node, rightDistance + 1);
                    return rightDistance + 1;
                }
            }
            return -1;
        }

        private void dfs(TreeNode root, int K, int distance, List<Integer> result) {
            if (root == null) {
                return;
            }
            if (distanceMap.containsKey(root)) {
                distance = distanceMap.get(root);
            }
            if (distance == K) {
                result.add(root.val);
            }
            dfs(root.left, K, distance + 1, result);
            dfs(root.right, K, distance + 1, result);
        }

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> result = new LinkedList<>();
            if (root == null || target == null || K < 0) {
                return result;
            }
            findTarget(root, target);
            dfs(root, K, distanceMap.get(root), result);
            return result;
        }
    }
}
