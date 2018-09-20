package src.com.Java;

public class _026_Remove_Duplicates_from_Sorted_Array_删除排序数组中的重复项 {
    class Solution {
        public int removeDuplicates(int[] A) {
            if (A.length == 0)
                return 0;
            int j = 0;
            for (int i = 0; i < A.length; i++)
                if (A[i] != A[j])
                    A[++j] = A[i];
            return ++j;
        }
    }
}
