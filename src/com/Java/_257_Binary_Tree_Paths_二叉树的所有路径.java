package src.com.Java;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  suzw
* @version 创建时间：2018年10月22日 下午3:52:46 
* 类说明 
* 给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
*/
public class _257_Binary_Tree_Paths_二叉树的所有路径 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<String> binaryTreePaths(TreeNode root){
		List<String> ans = new ArrayList<>();
		if (root!=null) searchPath(root, "", ans);
		return ans;
	}
	public static void searchPath(TreeNode root, String currentPath, List<String> ans ) {
		
		if (root.left==null && root.right ==null) 	ans.add(currentPath+root.val);
		if(root.left!=null) searchPath(root.left, currentPath+root.val+"->", ans);
		if(root.right!=null) searchPath(root.right, currentPath+root.val+"->", ans);
	}

}
