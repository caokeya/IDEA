package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年9月18日 下午4:10:22 
* 类说明 
* Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
Example:
Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/
public class _221_Maximal_Square_求二位数组中的最大1正方形 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maximalSquare(char[][] a) {
		if (a == null || a.length == 0 || a[0].length == 0) 
			return 0;
		int max = 0;
		int n = a.length,m = a[0].length;
		  // dp(i, j) represents the length of the square 
		  // whose lower-right corner is located at (i, j)
		  // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
		int[][] dp = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i-1][j-1] == '1') {
					dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1]))+1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max*max;
		
	}
}
