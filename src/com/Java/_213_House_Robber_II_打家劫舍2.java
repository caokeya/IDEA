package src.com.Java;

/**
 * @author suzw
 * @version 创建时间：2018年9月12日 下午3:30:28 类说明 随机一题
 * 
 * 
 *          你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
 *          这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻
 *          的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 示例 1:
输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。         
示例 2:
输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class _213_House_Robber_II_打家劫舍2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(int[] num) {
		if (num.length == 1)
			return num[0];
		return Math.max(rob(num, 0, num.length - 2), rob(num, 1, num.length - 1));
	}

	public int rob(int[] num, int lo, int hi) {
		int preYes = 0;
		int preNo = 0;
		for (int i = lo; i <= hi; i++) {
			int temp = preNo;
			preNo = Math.max(preNo, preYes);
			preYes = num[i] + temp;
		}
		return Math.max(preNo, preYes);

	}
}
