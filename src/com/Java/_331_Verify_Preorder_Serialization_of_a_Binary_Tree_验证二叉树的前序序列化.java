package src.com.Java;

/*
序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
示例 1:
输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
输出: true
 */
public class _331_Verify_Preorder_Serialization_of_a_Binary_Tree_验证二叉树的前序序列化 {
    /*
             * 假设我们尝试构建这棵树。在建造过程中，我们记录了出度和入度差=出度-入度的差值。
             * 当下一个节点到来时，我们将diff减少1，因为节点提供了一个in度。如果节点不是null，我们将diff增加2，因为它提供了2个out度。
             * 如果序列化是正确的，diff永远不应该是负的，完成时diff将为零。
     */

    class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] nodes = preorder.split(",");
            int diff = 1;
            for (String node : nodes) {
                if (--diff < 0)
                    return false;
                if (!node.equals("#"))
                    diff += 2;
            }
            return diff == 0;
        }
    }

}
