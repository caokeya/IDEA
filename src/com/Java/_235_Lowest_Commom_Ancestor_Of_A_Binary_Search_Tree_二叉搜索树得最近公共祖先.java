package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年10月9日 上午10:00:18 
* 
* 思路：
	二叉搜索树的性质： 左节点/左子树小于 中间/根节点， 右节点/右子树大于 中间/根节点。
		当p和q在同一侧，如都在左子树时，p.val-root.val 与q.val - root.val同号，此时根据p.val-root.val的符号，将root转移为其左节点或右节点
		当两个不同号时，说明找到了二者的公共祖先；
		
* 类说明 
* 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
示例 1:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
说明:
所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。
*/
public class _235_Lowest_Commom_Ancestor_Of_A_Binary_Search_Tree_二叉搜索树得最近公共祖先 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public  static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(Math.signum(p.val - root.val)*Math.signum(q.val - root.val)>0) {
        	root = p.val>root.val?root.right:root.left;
            	
        }
		
		return root;
    }
}
