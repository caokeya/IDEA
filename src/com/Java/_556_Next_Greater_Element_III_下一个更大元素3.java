package src.com.Java;

import java.util.Arrays;

/*
给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
示例 1:
输入: 12
输出: 21
示例 2:
输入: 21
输出: -1
 */
public class _556_Next_Greater_Element_III_下一个更大元素3 {
    //13254 -> 13[2]54 -> 13[2]5{4} -> 13[4]5{2} -> 13[4]25
    public class Solution {
        public int nextGreaterElement(int n) {
            char[] a = ("" + n).toCharArray();
            int i = a.length - 2;
            while (i >= 0 && a[i + 1] <= a[i]) {//从右向左找第一个不符合升序的数，位置记为index，如果index为-1，返回-1
                i--;
            }

            if (i < 0)
                return -1;
            int j = a.length - 1;
            while (j >= 0 && a[j] <= a[i]) {//从右向index找第一个比他大的数，交换index位置的数和这个比他大的数
                j--;
            }
            swap(a, i, j);
            reverse(a, i + 1);
            try {
                return Integer.parseInt(new String(a));
            } catch (Exception e) {
                return -1;
            }
        }

        private void reverse(char[] a, int start) {
            int i = start, j = a.length - 1;
            while (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        private void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public class Solution2 {
        public int nextGreaterElement(int n) {
            char[] number = (n + "").toCharArray();

            int i, j;
            // I) Start from the right most digit and find the first digit that is smaller than the digit next to it.
            for (i = number.length - 1; i > 0; i--)
                if (number[i - 1] < number[i])
                    break;

            // If no such digit is found, its the edge case 1.
            if (i == 0)
                return -1;

            // II) Find the smallest digit on right side of (i-1)'th digit that is greater than number[i-1]
            int x = number[i - 1], smallest = i;
            for (j = i + 1; j < number.length; j++)
                if (number[j] > x && number[j] <= number[smallest])
                    smallest = j;

            // III) Swap the above found smallest digit with number[i-1]
            char temp = number[i - 1];
            number[i - 1] = number[smallest];
            number[smallest] = temp;

            // IV) Sort the digits after (i-1) in ascending order
            Arrays.sort(number, i, number.length);

            long val = Long.parseLong(new String(number));
            return (val <= Integer.MAX_VALUE) ? (int) val : -1;
        }
    }
}
