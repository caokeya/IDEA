package src.com.Java;

import java.util.LinkedList;
import java.util.Queue;

/** 
* @author  suzw
* @version 创建时间：2018年6月4日 上午10:18:34 
* 类说明 
* 226. Invert Binary Tree
* Invert a binary tree.
Example:
Input:
     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:
     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/
public class _226_InvertBinaryTree_翻转二叉树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//建议使用递归
	public static TreeNode invertTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode temp =new TreeNode(0);
		TreeNode invertTemp;
		if (root == null) {
			return null;		
		}
		queue.add(root);
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.right !=null) {
				queue.add(temp.right);
			}
			if (temp.left !=null) {
				queue.add(temp.left);
			}
			if (temp.right != null || temp.left!= null) {
				invertTemp = temp.right;
				temp.right = temp.left;
				temp.left = invertTemp;
			}
		}
		
		return root;
	}
	public static TreeNode invertTreeByRecursion(TreeNode root) {
		if (root == null) {
			return null;
			
		}
		invertTreeByRecursion(root.right);
		invertTreeByRecursion(root.left);
		TreeNode temp = new TreeNode(0);
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
		
	}

}

