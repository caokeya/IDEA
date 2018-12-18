package src.com.Java;

/**
 * @author suzw
 * @version 创建时间：2018年10月26日 下午2:56:25 类说明
 *          给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * 
 *          h 指数的定义: “一位有 h 指数的学者，代表他（她）的 N 篇论文中至多有 h 篇论文，分别被引用了至少 h 次，其余的 N - h
 *          篇论文每篇被引用次数不多于 h 次。”
 * 
 *          示例:
 * 
 *          输入: citations = [3,0,6,1,5] 输出: 3 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了
 *          3, 0, 6, 1, 5 次。 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h
 *          指数是 3。 说明: 如果 h 有多种可能的值，h 指数是其中最大的那个。 
 *          https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
 *          This type of problems always
 *          throw me off, but it just takes some getting used to. The idea
 *          behind it is some bucket sort mechanisms. First, you may ask why
 *          bucket sort. Well, the h-index is defined as the number of papers
 *          with reference greater than the number. So assume n is the total
 *          number of papers, if we have n+1 buckets, number from 0 to n, then
 *          for any paper with reference corresponding to the index of the
 *          bucket, we increment the count for that bucket. The only exception
 *          is that for any paper with larger number of reference than n, we put
 *          in the n-th bucket.
 * 
 *          Then we iterate from the back to the front of the buckets, whenever
 *          the total count exceeds the index of the bucket, meaning that we
 *          have the index number of papers that have reference greater than or
 *          equal to the index. Which will be our h-index result. The reason to
 *          scan from the end of the array is that we are looking for the
 *          greatest h-index. For example, given array [3,0,6,5,1], we have 6
 *          buckets to contain how many papers have the corresponding index.
 *          Hope to image and explanation help.
 */
public class _274_H_Index_H引用指数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int hIndex(int[] citations) {
		int sum = 0;
		int n = citations.length;
		int[] counts = new int[n + 1];
		/*
		 * for (int i = 0; i < counts.length; i++) { if (citations[i]>=i) { counts[i]++;
		 * } }
		 */
		for (int i : citations) {
			if (i >= n) {
				counts[n]++;
			} else
				counts[i]++;
		}

		for (int i = n; i >= 0; i--) {
			sum += counts[i];
			if (sum >= i) {
				return i;
			}
		}

		return 0;
	}

}
