package src.com.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： 
counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
示例:
输入: [5,2,6,1]
输出: [2,1,1,0] 
解释:
5 的右侧有 2 个更小的元素 (2 和 1).
2 的右侧仅有 1 个更小的元素 (1).
6 的右侧有 1 个更小的元素 (1).
1 的右侧有 0 个更小的元素.
 */
public class _315_Count_of_Smaller_Numbers_After_Self_计算右侧小于当前元素的个数_难 {
    public class SolutionMerge {

        public List<Integer> countSmaller(int[] nums) {
            int len = (nums == null ? 0 : nums.length);

            int[] idxs = new int[len];
            int[] count = new int[len];

            for (int i = 0; i < len; i++)
                idxs[i] = i;

            mergeSort(nums, idxs, 0, len, count);

            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i : count)
                list.add(i);

            return list;
        }

        private void mergeSort(int[] nums, int[] idxs, int start, int end, int[] count) {
            if (start + 1 >= end)
                return;

            int mid = (end - start) / 2 + start;
            mergeSort(nums, idxs, start, mid, count);
            mergeSort(nums, idxs, mid, end, count);

            merge(nums, idxs, start, end, count);
        }

        private void merge(int[] nums, int[] idxs, int start, int end, int[] count) {
            int mid = (end - start) / 2 + start;

            int[] tmp = new int[end - start];
            int[] tmpidx = new int[end - start];
            int i = start, j = mid, k = 0;
            while (k < end - start) {
                if (i < mid) {
                    if (j < end && nums[j] < nums[i]) {
                        tmpidx[k] = idxs[j];
                        tmp[k++] = nums[j++];
                    } else {
                        count[idxs[i]] += j - mid; // add those already counted
                        tmpidx[k] = idxs[i];
                        tmp[k++] = nums[i++];
                    }

                } else {
                    tmpidx[k] = idxs[j];
                    tmp[k++] = nums[j++];
                }
            }

            System.arraycopy(tmpidx, 0, idxs, start, end - start);
            System.arraycopy(tmp, 0, nums, start, end - start);
        }
    }

    class SolutionTree {
        class TreeNode {
            int dup, val, small;
            TreeNode left, right;

            TreeNode(int val) {
                this.val = val;
                dup = 1;
                small = 0;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            List<Integer> ans = new LinkedList<>();
            if (n == 0)
                return ans;
            TreeNode root = null;
            for (int i = n - 1; i >= 0; i--) {
                root = insert(nums[i], root, ans, 0);
            }
            return ans;
        }

        public TreeNode insert(int t, TreeNode x, List<Integer> ans, int pre) {
            if (x == null) {
                ans.add(0, pre);
                return new TreeNode(t);
            }
            if (x.val == t) {
                x.dup++;
                ans.add(0, pre + x.small);
            } else if (x.val > t) {
                x.small++;
                x.left = insert(t, x.left, ans, pre);

            } else {
                x.right = insert(t, x.right, ans, pre + x.small + x.dup);
            }
            return x;
        }

    }
}
