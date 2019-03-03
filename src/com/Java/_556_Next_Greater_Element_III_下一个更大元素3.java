package com.Java;

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
    
    class Solution2 {
        
        //1. go from right -> left to find the first decreasing number num[i]; if no such number return -1;
        //2. swap num[i] with the smaillest digit in its right which is greater than num[i];
        //3. reverse the right part of num[i];
        public int nextGreaterElement(int n) {
            if (n < 10)
                return -1;
            char[] arr = (n + "").toCharArray();

            int len = arr.length;
            int[] nums = new int[10];
            Arrays.fill(nums, -1);

            int idx = len - 2;
            nums[arr[len - 1] - '0'] = len - 1;
            while (idx >= 0) {
                if (nums[arr[idx] - '0'] == -1)
                    nums[arr[idx] - '0'] = idx;
                if (arr[idx] >= arr[idx + 1])
                    idx--;
                else
                    break;
            }
            if (idx == -1)
                return -1; // all none-decreasing from right return -1;

            int value = arr[idx] - '0';
            for (int i = value + 1; i < 10; i++) {
                if (nums[i] != -1) {
                    swap(arr, idx, nums[i]);
                    break;
                }
            }
            reverse(arr, idx+1, len-1);
            long next = Integer.parseInt(new String(arr));
            if(next > n && next<=Integer.MAX_VALUE) return (int)next;
            else return -1;
        }
        
        public void reverse(char[] arr, int start, int end){
            for(int i=0; i<=(end-start)/2; i++)  swap(arr, start+i, end-i);
        }
        
        public void swap(char[] arr, int i, int j){
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
