package src.com.Java;

/** 
* @author  suzw
* @version 创建时间：2018年10月30日 上午9:49:29 
* 类说明 
* 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)
链接有4中C++方法
1. DP;2static DP,减少重复计算；3 Mathematic;4 BFS
下面挑出了1（2）（22ms）和3(1ms)。
*/
public class _279_Perfect_Squares_将n拆为完全平方数的和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//方法一：动态规划Dynamic Programming
	
	public static int numSquares1(int n ) {
		if(n<=0)	return 0;
		int[] dp = new int[n+1];
		for(int i = 1;i<=n;i++) {
			dp[i] = Integer.MAX_VALUE;
			int sqrt = (int)Math.sqrt(i);
			//如果i是完全平方数，那么就将dp[i]记为1
			if(sqrt * sqrt == i) {
				dp[i] = 1;
				continue;
			}
			//对于非完全平方数，他们有以下几种情况：我们从中选取最小的值
			/*
			 * dp[n-1]+1
			 * dp[n-4]+1
			 * dp[n-9]+1
			 * dp[n-16]+1等等
			 */
			for(int j =1;j <= sqrt; j++) {
				int dif = i - j*j;
				dp[i] = Math.min(dp[i], dp[dif]+1);
			}
		}
		return dp[n];
	}
	/*
	 * dp[0] = 0 
dp[1] = dp[0]+1 = 1
dp[2] = dp[1]+1 = 2
dp[3] = dp[2]+1 = 3
dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }  = Min{ dp[3]+1, dp[0]+1 }  = 1				
dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }  = Min{ dp[4]+1, dp[1]+1 }  = 2
						.
dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }       = 2
						.
dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
	 */
	/*
	 * 方法二：数学结论
	 * 基于四平方定理[ Lagrange's Four Square theorem ]： 任何一个正整数都可以表示成不超过四个整数的平方之和。
	 * 结果只有1，2，3，4，四种情况
	 * 
	 * 
	 
	 */
	
	public static int numSquaresByMathematical(int n) {
		int sqrt = (int)Math.sqrt(n);
		//1. 当这个数时完全平方数时，返回1
		if(sqrt * sqrt == n)	return 1;
		//2. 当这个数可以写成 n = 4^k * (8*m+7)时，返回4
		//Legendre's three-square theorem
		while((n & 3) == 0)	//n%4 == 0
			n >>=2;
		if((n & 7 ) == 7)// n %8 == 7
			return 4;
		//3. 如果这个数能表示成两个完全平方数的和的形式，则返回2
		for (int i = 1; i <=sqrt; i++) {
			int sqrt_i = (int)Math.sqrt(n - i*i);
			if (sqrt_i*sqrt_i == (n- i*i)) 		
				return 2;
		}
		//4. 否则返回3
		return 3;
	}
}
