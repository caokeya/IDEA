package com.Java;

/*
序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 
您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
编码的字符串应尽可能紧凑。
 */
public class _449_Serialize_and_Deserialize_BST_序列化和反序列化二叉搜索树 {
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

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null)
                return;
            sb.append(root.val);
            if (root.left != null) {
                sb.append(" ");
                serialize(root.left, sb);
            }
            if (root.right != null) {
                sb.append(" ");
                serialize(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty())
                return null;
            String[] tokens = data.split(" ");
            return deserialize(tokens, 0, tokens.length - 1);
        }

        private TreeNode deserialize(String[] tokens, int l, int r) {
            if (l > r)
                return null;
            int val = Integer.valueOf(tokens[l]);
            TreeNode root = new TreeNode(val);
            int i = 0;
            for (i = l + 1; i <= r; i++) {
                if (Integer.valueOf(tokens[i]) > val) {
                    break;
                }
            }
            root.left = deserialize(tokens, l + 1, i - 1);
            root.right = deserialize(tokens, i, r);
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}
