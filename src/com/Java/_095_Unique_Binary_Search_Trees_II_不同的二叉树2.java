package src.com.Java;

import java.util.ArrayList;
import java.util.List;
/*
给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
示例:
输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class _095_Unique_Binary_Search_Trees_II_不同的二叉树2 {
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
        public List<TreeNode> generateTrees(int n) {
            if (n == 0)
                return new ArrayList<>();
            return helper(1, n);
        }

        public List<TreeNode> helper(int start, int end) {
            List<TreeNode> res = new ArrayList<>();
            if (start > end)
                res.add(null);
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftlist = helper(start, i - 1);
                List<TreeNode> rightlist = helper(i + 1, end);
                for (TreeNode left : leftlist) {
                    for (TreeNode right : rightlist) {
                        TreeNode n = new TreeNode(i);
                        n.left = left;
                        n.right = right;
                        res.add(n);
                    }
                }
            }
            return res;
        }
    }
}
