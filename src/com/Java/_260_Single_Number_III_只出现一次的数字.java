package src.com.Java;

/**
 * @author suzw
 * @version 创建时间：2018年10月23日 下午8:12:21 类说明 给定一个整数数组
 *          nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 
 *          示例 :
 * 
 *          输入: [1,2,1,3,2,5] 输出: [3,5] 注意：
 * 
 *          结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 *          你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * 
 *          we need to use XOR to solve this problem. But this time, we need to
 *          do it in two passes: • In the first pass, we XOR all elements in the
 *          array, and get the XOR of the two numbers we need to find. Note that
 *          since the two numbers are distinct, so there must be a set bit (that
 *          is, the bit with value '1') in the XOR result. Find out an
 *          arbitrary【任意的】 set bit (for example, the rightmost set bit).
 *          因为有两个数字是不同的，所以在XOR结果中必须有一个位的值是1。找到这个设置位【diff &= - diff】
 * 
 *          • 为什么diff＆= -diff或diff＆=〜（diff-1）可以找到一个不同的位？ a XOR b = 6 (diff)，a =
 *          0011,b=0101 6 => 0110 -6 => 1010 (2s complement of 6) 6 & -6 => 0010
 *          //this is used as a mask to separate 3 and 5 from the nums[]
 *          当diff的第1和第2位为1时，输入（a和b）中的这些位必须不同，以便在diff中产生1（设置位）。只
 *          要我们选择其中一个位（@zhiqing_xiao将其称为任意位）作为掩码将nums []分成两组，两个不同
 *          的数字a和b将转到不同的组。此时的diff表示的是ab其中的一个不同位，并且： 0010 &0011 = 0010 0010 &0101
 *          = 0000
 * 
 *          仅供参考，另一种在Java中找到此掩码的低效方法是 diff = (int)
 *          Math.pow(2,Integer.numberOfTrailingZeros(diff));
 * 
 * 
 *          • In the second pass, we divide all numbers into two groups, one
 *          with the aforementioned bit set, another with the aforementinoed bit
 *          unset. Two different numbers we need to find must fall into thte two
 *          distrinct groups. XOR numbers in each group, we can find a number in
 *          either group. 在第二遍中，我们将所有数字分成两组：一组具有上述位，另一组的上述位未设置。我们需要找到的
 *          两个不同的数字肯定属于两个分散的群体【因为此时a和b与diff进行&操作，】。每组中的XOR编 号，我们可以在任一组中找
 *          到一个数字。
 *          Complexity: • Time: O (n) • Space: O (1) A Corner Case: • When diff
 *          == numeric_limits<int>::min(), -diff is
 *          also numeric_limits<int>::min(). Therefore, the value of diff after
 *          executing diff &= -diff is still numeric_limits<int>::min(). The
 *          answer is still correct.
 * 
 */
public class _260_Single_Number_III_只出现一次的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] singleNumber(int[] nums) {
		// Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// Get its last set bit
		// diff &= -diff;
		diff = (int) Math.pow(2, Integer.numberOfTrailingZeros(diff));

		// Pass 2 :
		int[] rets = { 0, 0 }; // this array stores the two numbers we will return
		for (int num : nums) {
			if ((num & diff) == 0) // the bit is not set
			{
				rets[0] ^= num;
			} else // the bit is set
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}
}
