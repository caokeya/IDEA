package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
答案中每个树的每个结点都必须有 node.val=0。
你可以按任何顺序返回树的最终列表。
示例：
输入：7
输出：[[0,0,0,null,null,0,0,null,null,0,0],
     [0,0,0,null,null,0,0,0,0],
     [0,0,0,0,0,0,0],
     [0,0,0,0,0,null,null,null,null,0,0],
     [0,0,0,0,0,null,null,0,0]]
 */
public class _894_All_Possible_Full_Binary_Trees_所有可能的满二叉树 {
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
        Map<Integer, List<TreeNode>> cache = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int N) {
            List<TreeNode> res = new ArrayList<>();
            if (N % 2 == 0)
                return res;
            if (cache.get(N) != null)
                return cache.get(N);
            if (N == 1) {
                res.add(new TreeNode(0));
                return res;
            }
            for (int i = 1; i < N - 1; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N - i - 1);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(0);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
            cache.put(N, res);
            return res;
        }
    }
}
