package src.com.Java;

/**
 * @author suzw
 * @version 创建时间：2018年10月29日 上午9:08:04 类说明
 *          给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 * 
 *          h 指数的定义: “一位有 h 指数的学者，代表他（她）的 N 篇论文中至多有 h 篇论文，分别被引用了至少 h 次，其余的 N - h
 *          篇论文每篇被引用次数不多于 h 次。"
 * 
 *          示例:
 * 
 *          输入: citations = [0,1,3,5,6] 输出: 3 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了
 *          0, 1, 3, 5, 6 次。 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h
 *          指数是 3。 进阶：
 * 
 *          这是 H指数 的延伸题目，本题中的 citations 数组是保证有序的。 你可以优化你的算法到对数时间复杂度吗？
 *          解答：二分查找，找到“中间点"满足： Citations[index]>=citations.length - index
 */
public class _275_HIndex_II_H指数2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0};
		//int[] nums = {0,1,3,5,6};
		System.out.println(hIndex(nums));
	}

	/*
	 * case 1: citations[mid] == len-mid, then it means there are citations[mid]
	 * papers that have at least citations[mid] citations. 
	 * case 2: citations[mid] >len-mid, then it means there are citations[mid] papers that have more than
	 * citations[mid] citations, so we should continue searching in the left half
	 
	 * case 3: citations[mid] < len-mid, we should continue searching in the right
	 * side After iteration, it is guaranteed that right+1 is the one we need to 
	 * find (i.e. len-(right+1) papars have at least len-(righ+1) citations)
	 */
	public static int hIndex(int[] citations) {
        
		if(citations.length == 0) return 0;
        int n = citations.length;
        int lo = 0;
        int hi = citations.length-1;
        while(lo<=hi) {
        	int mid = (lo+hi)/2;
        	if(citations[mid]==n-mid)	
        		return n - mid;
        		//return citations[mid];
        	//二分查找，每次lo和hi都进行一次移位，避免陷入死循环
        	else if(citations[mid]<n-mid) lo = mid+1;
        	else if(citations[mid]>n-mid) hi = mid-1;
        }
        
        return n-lo;
	}
}
