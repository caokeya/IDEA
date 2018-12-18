package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年10月15日 上午11:09:40 
* 类说明 
* 思路1：
* 	先提取出对角线元素，确定目标元素可能出现的范围：
* 比如14，在对角线元素中，9<14<17.那么目标可能出现在第三排9之后，第四排17之前

* Pick One

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:
Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.
*/
public class _240_Search_A_2D_Matrix_II_在二维矩阵中搜索元素 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return false;
		}
    	//从matrix的右上角开始比较
    	int col = matrix[0].length-1;	//列
    	int row = 0;					//行
    	while(col>=0 && row<matrix.length) {
    		if(target == matrix[row][col])
    			return true;
    		//比行最大值大时，切换到下一行
    		else if(target > matrix[row][col])
    			row++;
    		//比行最大值小时，像左移动
    		else //if(target < matrix[row][col])
    			col--;
    	}
    		
    	
    	return false;
    	
    }
    /*
     * 递归写法：
     public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        return helper(matrix, matrix.length - 1, 0, target);
    }
    
    private boolean helper(int[][] matrix, int x, int y, int target) {
        if (x < 0 || y > matrix[0].length - 1) {
            return false;
        }
        if (matrix[x][y] == target) {
            return true;
        } else if (matrix[x][y] > target) {
            return helper(matrix, x - 1, y, target);
        } else {
            return helper(matrix, x, y + 1, target);
        }
    }
     */
    
}
