package src.com.Java;

/*
数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。
全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，
局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。
当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。
示例 1:
输入: A = [1,0,2]
输出: true
解释: 有 1 个全局倒置，和 1 个局部倒置。
示例 2:
输入: A = [1,2,0]
输出: false
解释: 有 2 个全局倒置，和 1 个局部倒置。
 */
public class _775_Global_and_Local_Inversions_全局倒置与局部倒置 {
    /*
    所有局部倒置对都是全局倒置对。 如果全局逆序对的数目等于局部逆序对的数目，则意味着排列中的所有全局逆序对都是局部逆序对。
    这也意味着在i+2<=j的情况下，我们找不到A[i] > A[j]。 换句话说，max(A[i]] < A[i+2]
    遍历A并保持当前最大的数字cmax，然后检查条件cmax < A[I +2]
    */
    class Solution {
        public boolean isIdealPermutation(int[] A) {
            int cmax = 0;
            for (int i = 0; i < A.length - 2; ++i) {
                cmax = Math.max(cmax, A[i]);
                if (cmax > A[i + 2])
                    return false;
            }
            return true;
        }
    }

    /*
    基于这个想法，我试图安排一个理想的排列。然后我发现， 我只能把I放在A[I -1] A[I]或A[I +1]。
    我想起来了，检查A (i) - i是否等于-1 0或1会更简单
    */
    class Solution2 {
        public boolean isIdealPermutation(int[] A) {
            for (int i = 0; i < A.length; i++) {
                if (Math.abs(i - A[i]) > 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
