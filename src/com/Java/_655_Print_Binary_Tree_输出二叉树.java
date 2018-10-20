package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/*
在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
    行数 m 应当等于给定二叉树的高度。
    列数 n 应当总是奇数。
    根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。
    你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。
    即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
    每个未使用的空间应包含一个空的字符串""。
    使用相同的规则输出子树。
示例 1:
输入:
     1
    /
   2
输出:
[["", "1", ""],
 ["2", "", ""]]
示例 2:
输入:
     1
    / \
   2   3
    \
     4
输出:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
示例 3:
输入:
      1
     / \
    2   5
   / 
  3 
 / 
4 
输出:
[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]

 */
public class _655_Print_Binary_Tree_输出二叉树 {
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
        public List<List<String>> printTree(TreeNode root) {
            int height = getTreeHeight(root);
            int columns = (1 << height) - 1;
            List<List<String>> result = new ArrayList<>();
            for (int i = 0; i < height; i++) {
                List<String> row = new ArrayList<>();
                for (int col = 0; col < columns; col++) {

                    row.add("");
                }
                result.add(row);
            }

            fill(root, result, 0, 0, columns);
            return result;
        }

        private void fill(TreeNode node, List<List<String>> result, int row, int left, int right) {
            if (node == null) {
                return;
            }
            result.get(row).set((left + right) / 2, String.valueOf(node.val));

            fill(node.left, result, row + 1, left, (left + right) / 2);
            fill(node.right, result, row + 1, (left + right + 1) / 2, right);
        }

        private int getTreeHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }

            return Math.max(getTreeHeight(node.left), getTreeHeight(node.right)) + 1;
        }
    }
}
