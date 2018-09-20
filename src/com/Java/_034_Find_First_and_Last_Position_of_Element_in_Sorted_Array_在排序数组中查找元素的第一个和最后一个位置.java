package src.com.Java;

public class _034_Find_First_and_Last_Position_of_Element_in_Sorted_Array_在排序数组中查找元素的第一个和最后一个位置 {
    class Solution {
        public int[] searchRange(int[] a, int t) {
            int i = 0;
            int j = a.length - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (a[mid] < t) {
                    i = mid + 1;
                } else if (a[mid] > t) {
                    j = mid - 1;
                } else {
                    int start = mid;
                    int end = mid;
                    while (start >= 0 && a[start] == t) {
                        start--;
                    }
                    while (end < a.length && a[end] == t) {
                        end++;
                    }
                    int[] res = new int[] { start + 1, end - 1 };
                    return res;
                }
            }
            return new int[] { -1, -1 };
        }
    }
}