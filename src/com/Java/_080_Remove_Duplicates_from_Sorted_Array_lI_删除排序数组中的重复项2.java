package src.com.Java;

public class _080_Remove_Duplicates_from_Sorted_Array_lI_删除排序数组中的重复项2 {
    class Solution {
        public int removeDuplicates(int[] a) {
            if (a.length == 0) {
                return 0;
            }
            int length = 2;
            for (int i = 2; i < a.length; i++) {
                if (a[length - 2] != a[i]) {
                    a[length] = a[i];
                    length++;
                }
            }
            return length;
        }
    }
}
