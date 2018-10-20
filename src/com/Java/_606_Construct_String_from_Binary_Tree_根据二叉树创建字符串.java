package src.com.Java;

/*
你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
示例 1:
输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     
输出: "1(2(4))(3)"
解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
示例 2:
输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 
输出: "1(2()(4))(3)"
解释: 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */
public class _606_Construct_String_from_Binary_Tree_根据二叉树创建字符串 {
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
        public String tree2str(TreeNode t) {
            StringBuffer sb = new StringBuffer();
            parse(t, sb);
            return sb.toString();
        }

        private void parse(TreeNode t, StringBuffer sb) {
            if (t == null)
                return;
            sb.append(t.val);

            if (t.left != null) {
                sb.append("(");
                parse(t.left, sb);
                sb.append(")");
            }

            if (t.right != null) {
                if (t.left == null)
                    sb.append("()");
                sb.append("(");
                parse(t.right, sb);
                sb.append(")");
            }
        }
    }
}
