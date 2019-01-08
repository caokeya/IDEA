package src.com.Java;

/*
四叉树是一种树数据，其中每个内部节点恰好有四个子节点:左上角、右上角、左下角和右下角。
四叉树通常被用来划分一个二维空间，通过递归地将其细分为四个象限或区域。
我们希望在四叉树中存储真/假信息。四叉树用来表示N * N的布尔网格。
对于每个节点，它将被细分为四个子节点，直到它表示的区域中的值都相同。
每个节点都有另外两个布尔属性:isLeaf和val. isLeaf，当且仅当该节点是叶节点时为真。叶节点的val属性包含它表示的区域的值。
例如，下面是两个四叉树 A 和 B：
A:
+-------+-------+   T: true
|       |       |   F: false
|   T   |   T   |
|       |       |
+-------+-------+
|       |       |
|   F   |   F   |
|       |       |
+-------+-------+
topLeft: T
topRight: T
bottomLeft: F
bottomRight: F
B:               
+-------+---+---+
|       | F | F |
|   T   +---+---+
|       | T | T |
+-------+---+---+
|       |       |
|   T   |   F   |
|       |       |
+-------+-------+
topLeft: T
topRight:
     topLeft: F
     topRight: F
     bottomLeft: T
     bottomRight: T
bottomLeft: T
bottomRight: F
您的任务是实现一个函数，该函数将获取两个四叉树并返回表示这两个树的逻辑或(或联合)的四叉树
A:                 B:                 C (A or B):
+-------+-------+  +-------+---+---+  +-------+-------+
|       |       |  |       | F | F |  |       |       |
|   T   |   T   |  |   T   +---+---+  |   T   |   T   |
|       |       |  |       | T | T |  |       |       |
+-------+-------+  +-------+---+---+  +-------+-------+
|       |       |  |       |       |  |       |       |
|   F   |   F   |  |   T   |   F   |  |   T   |   F   |
|       |       |  |       |       |  |       |       |
+-------+-------+  +-------+-------+  +-------+-------+
 */
public class _558_Quad_Tree_Intersection_四棵树十字路口 {
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
    }

    class Solution {
        public Node intersect(Node q1, Node q2) {
            if (q1.isLeaf) {
                return q1.val ? q1 : q2;
            }
            if (q2.isLeaf) {
                return q2.val ? q2 : q1;
            }
            q1.topLeft = intersect(q1.topLeft, q2.topLeft);
            q1.topRight = intersect(q1.topRight, q2.topRight);
            q1.bottomLeft = intersect(q1.bottomLeft, q2.bottomLeft);
            q1.bottomRight = intersect(q1.bottomRight, q2.bottomRight);
            if (q1.topLeft.isLeaf && q1.topRight.isLeaf && 
                q1.bottomLeft.isLeaf && q1.bottomRight.isLeaf&& 
                q1.topLeft.val == q1.topRight.val && 
                q1.topRight.val == q1.bottomLeft.val&& 
                q1.bottomLeft.val == q1.bottomRight.val) {
                q1.isLeaf = true;
                q1.val = q1.topLeft.val;
            }
            return q1;
        }
    }
}
