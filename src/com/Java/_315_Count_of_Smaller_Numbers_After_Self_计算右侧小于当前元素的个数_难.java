package src.com.Java;

import java.util.ArrayList;
import java.util.Collections;
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
    class SolutionTree {
        // Logic:
        //          We need count of smaller elements 'after' self. So I should have already processed the elements to the right
        //          So logically we build the tree by processing from right of the array
        //          We need to account for duplicates, so we will maintain a count of number of times the current element occurred
        // Time:  O(nlogn) for balanced bst
        // Space: O(n) for constructing tree
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new ArrayList<Integer>();
            if (nums == null || nums.length == 0)
                return res;

            TreeNode root = new TreeNode(nums[nums.length - 1]);//最后一个数
            res.add(0);

            for (int i = nums.length - 2; i >= 0; i--) {
                int count = insert(root, nums[i]);
                res.add(count);
            }

            Collections.reverse(res);
            return res;
        }

        public int insert(TreeNode root, int val) {
            int cnt = 0;
            while (true) {
                if (val <= root.val) {
                    root.count += 1;    // increase root count coz this is one node going into left subtree
                    // if we have reached the end of the path, create new node
                    if (root.left == null) {
                        root.left = new TreeNode(val);
                        break;
                    } else {
                        root = root.left;
                    }
                } else {
                    // we are going to the right so add the size of left subtree we have passed
                    cnt += root.count;
                    if (root.right == null) {
                        root.right = new TreeNode(val);
                        break;
                    } else {
                        root = root.right;
                    }

                }
            }
            return cnt;
        }

        public class TreeNode {
            TreeNode left, right;
            int val;    // key that represents the node
            int count;  // size of to the left subtree

            public TreeNode(int val) {
                this.val = val;
                this.count = 1;
            }
        }
    }


    public class SolutionMerge {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> results = new ArrayList<>();
            int len = nums.length;
            int[] indices = new int[len];
            int[] count = new int[len];
            for (int i = 0; i < len; i++) {
                indices[i] = i;
            }
            int left = 0, right = len - 1;
            mergeSort(nums, indices, count, left, right);
            for (int i : count) {
                results.add(i);
            }
            return results;
        }

        private void mergeSort(int[] nums, int[] indices, int[] count, int left, int right) {
            if (left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeSort(nums, indices, count, left, mid);
            mergeSort(nums, indices, count, mid + 1, right);
            merge(nums, indices, count, left, right);
        }

        private void merge(int[] nums, int[] indices, int[] count, int left, int right) {
            int mid = left + (right - left) / 2;
            int l1 = left, r1 = mid;
            int l2 = mid + 1, r2 = right;
            int index = 0;
            int rightCount = 0;
            int[] newIndices = new int[right - left + 1];
            while (l1 <= r1 && l2 <= r2) {
                if (nums[indices[l1]] > nums[indices[l2]]) {
                    newIndices[index++] = indices[l2++];
                    rightCount++;
                } else {
                    count[indices[l1]] += rightCount;
                    newIndices[index++] = indices[l1++];
                }
            }
            while (l1 <= r1) {
                count[indices[l1]] += rightCount;
                newIndices[index++] = indices[l1++];
            }
            while (l2 <= r2) {
                newIndices[index++] = indices[l2++];
            }
            for (int i = left; i <= right; i++) {
                indices[i] = newIndices[i - left];
            }
        }
    }
}
