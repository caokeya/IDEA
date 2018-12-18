package src.com.Java;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/** 
* @author  suzw
* @version 创建时间：2018年9月18日 下午5:05:29 
* 类说明 
*/
public class _222_Count_Complete_Tree_Nodes_完全二叉树的节点个数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;      
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            result.add(temp);
            
            if(temp.left!=null)
                q.add(temp.left);
            
            if(temp.right!=null)
                q.add(temp.right);
        }
        return result.size();
    }
	/*
	 * 
	 * 当递归转化为循环且该循环并不需要使用栈这种数据结构时，
	 * 性能往往会得到质的飞跃。在上面的思路二中采用递归，在这里我们将递归转变为循环。
	 * 同时我们只需要计算一次树的高度，因为每一次选择的子树的高度都是上一个高度-1。
	 */
	int height2(TreeNode root){
        if(root==null) return -1;
        int height = 0;
        while(root.left!=null) {height++; root=root.left;}
        return height;
    }
    
    public int countNodes2(TreeNode root) {
        int count = 0;
        int height = height2(root);
        while(root!=null){
            if(height2(root.right)==height-1){
                count += 1<<height;
                root = root.right;
            }else{
                count += 1<<height-1;
                root = root.left;
            }
            height--;
        }
        return count;
    }
    
    
	/*
	 * 该方法超时
	 */
	public static int countNodes_bak(TreeNode root) {
		
		if (root == null)  return 0;
		int num = 1;
		//直接return比下面的慢一些
		//return 1+countNodes(root.left)+countNodes(root.right);
		
		if (root.left!= null) {
			num +=countNodes_bak(root.left);
		}
		else return num;
		if (root.right!= null) {
			num +=countNodes_bak(root.right);
		}
		return num;
		
		
	}
	
}
