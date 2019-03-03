package com.Java;

/*
https://leetcode-cn.com/problems/construct-quad-tree/description/
我们想要使用一棵四叉树来储存一个 N x N 的布尔值网络。网络中每一格的值只会是真或假。
树的根结点代表整个网络。对于每个结点, 它将被分等成四个孩子结点直到这个区域内的值都是相同的.
每个结点还有另外两个布尔变量: isLeaf 和 val。isLeaf 当这个节点是一个叶子结点时为真。val 变量储存叶子结点所代表的区域的值。
 */
public class _427_Construct_Quad_Tree_建立四叉树 {
    /*
     * Definition for a QuadTree node.
     */
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    class Solution {
        public Node construct(int[][] grid) {
            if (grid == null || grid.length == 0)
                return null;
            return helper(grid, 0, grid.length - 1, 0, grid.length - 1);
        }

        private Node helper(int[][] grid, int ls, int le, int ws, int we) {
            if (ls > le || ws > we)
                return null;
            boolean isLeaf = true;
            int val = grid[ls][ws];
            for (int i = ls; i <= le; i++) {
                for (int j = ws; j <= we; j++) {
                    if (grid[i][j] != val) {
                        isLeaf = false;
                        break;
                    }
                }
            }
            if (isLeaf) {
                return new Node(val == 1, true, null, null, null, null);
            }
            int lm = ls + (le - ls) / 2;
            int wm = ws + (we - ws) / 2;
            return new Node(val == 1, false, helper(grid, ls, lm, ws, wm), helper(grid, ls, lm, wm + 1, we),
                    helper(grid, lm + 1, le, ws, wm), helper(grid, lm + 1, le, wm + 1, we));

        }
    }

    /*
     * Steps: To do this recusively, we have to split the grid into 4 smaller
     * sub-grids until the sub-grid's length is 1. The sub-grid whose length is 1 is
     * the leaf node. We merge the sub-grids if all four sub-grids are leaf nodes
     * and have same value. Time Complexity: O(N^2 logN), N is the length of the
     * grid. Space Complexity: O(N^2)
     */
    class Solution2 {
        public Node construct(int[][] grid) {
            return helper(grid, 0, 0, grid.length);
        }

        // len代表边长
        private Node helper(int[][] grid, int x, int y, int len) {
            if (len == 1)
                return new Node(grid[x][y] == 1, true, null, null, null, null);

            Node nodeTL = helper(grid, x, y, len / 2);
            Node nodeTR = helper(grid, x, y + len / 2, len / 2);
            Node nodeBL = helper(grid, x + len / 2, y, len / 2);
            Node nodeBR = helper(grid, x + len / 2, y + len / 2, len / 2);

            // Merge all child nodes
            if (nodeTL.isLeaf && nodeTR.isLeaf && nodeBL.isLeaf && nodeBR.isLeaf) {
                if (nodeTL.val && nodeTR.val && nodeBL.val && nodeBR.val)
                    return new Node(true, true, null, null, null, null);
                if (!nodeTL.val && !nodeTR.val && !nodeBL.val && !nodeBR.val)
                    return new Node(false, true, null, null, null, null);
            }

            return new Node(true, false, nodeTL, nodeTR, nodeBL, nodeBR);
        }
    }
}
