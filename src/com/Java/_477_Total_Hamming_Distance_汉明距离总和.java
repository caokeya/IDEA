package src.com.Java;
/*
两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
计算一个数组中，任意两个数之间汉明距离的总和。
示例:
输入: 4, 14, 2
输出: 6
解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 */
public class _477_Total_Hamming_Distance_汉明距离总和 {
    //考虑所有数字的同一个bit位，统计在这个bit位上出现的1的次数count，那么这个bit位在总的汉明距离中就贡献了count*(n-count)
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int total = 0, n = nums.length;
            for (int j=0;j<32;j++) {
                int bitCount = 0;
                for (int i=0;i<n;i++) 
                    bitCount += (nums[i] >> j) & 1;
                total += bitCount*(n - bitCount);
            }
            return total;
        }
        }
}
