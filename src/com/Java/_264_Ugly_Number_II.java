package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年10月24日 下午2:24:55 
* 类说明 
* Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
Example:
Input: n = 10
Output: 12

  关键是要实现每个数字可以并且必须由前一个数字乘以2,3或5生成，
例如
1 2 3 4 5 6 8 9 10 12 15 .. 
接下来是什么？
它必须是x * 2或y * 3或z * 5，其中x，y，z是现有数字。

我们如何确定x，y，z呢？
显然，可以只遍历迄今为止产生的序列从1 ... 15，直到找到这样的x，y和z是x * 2，Y * 3，Z * 5只比15更大的在这种情况下，x = 8，y = 6，z = 4。然后你比较x * 2，y * 3，z * 5所以你知道下一个数字将是x * 2 = 8 * 2 = 16. 
k，现在你有1,2,3,4，....，15 ，16，

然后下一步是什么？
你想再次做同样的过程来找到新的x，y，z，但你意识到，等等，我是否必须再次
遍历生成的序列？

没有！因为你知道上次，x = 8，y = 6，z = 4和x = 8用于生成16，所以这一次，你可以立即知道new_x = 9（生成8后8的下一个数字是9）序列），y = 6，z = 4。
然后你需要比较new_x * 2，y * 3，z * 5.你知道下一个数字是9 * 2 = 18;

而你也知道，由于new_x = 9这次使用了下一个x将是10。
但接下来会是什么？显然，如果y = 6,6 * 3 = 18，这已经在本轮中产生。所以你还需要将下一个y从6更新到8。

基于上面的想法，您实际上可以从一开始就生成x，y，z，并相应地更新x，y，z。它最终得到O（n）解决方案。

Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
15 16 18 20 

1 1
2 2
3 3
4 4 
5 5
6 6
7 8
8 9
9 10
10 12
11 15 
12 16
13 18
14 20
15 24
16 25
17 27
18 30

*/
public class _264_Ugly_Number_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public  static int nthUglyNumber(int n) {
	        int[] nums = new int[n];
	        int index2= 0,index3 = 0, index5 = 0;
	        int num2 = 2, num3 = 3, num5 = 5;
	        nums[0] = 1;
	        
	        for(int i =1;i<n;i++) {
	        	
	        	int min = Math.min(Math.min(num2, num3), num5);
	        	nums[i] = min;
	        	if(min == num2)	num2 = 2*nums[++index2];
	        	if(min == num3)	num3 = 3*nums[++index3];
	        	if(min == num5)	num5 = 5*nums[++index5];
                /*
	        	//或者：
	        	int min = Math.min(Math.min(nums[index2]*2, nums[index3]*3), nums[index5]*5);
	        	nums[i] = min;
	        	if(min == nums[index2]*2)	index2++;
	        	if(min == nums[index3]*3)	index3++;
	        	if(min == nums[index5]*5)	index5++;
	        	*/
	        }
	        
	        return nums[n-1];
	    
	 }
}
