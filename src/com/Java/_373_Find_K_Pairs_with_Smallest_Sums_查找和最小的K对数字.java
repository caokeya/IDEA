package src.com.Java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
示例 1:
输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]
解释: 返回序列中的前 3 对数：
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 */
public class _373_Find_K_Pairs_with_Smallest_Sums_查找和最小的K对数字 {
    class Solution {
        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<int[]> res = new ArrayList<int[]>();
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
                return res;
            }
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return (a[0] + a[1]) - (b[0] + b[1]);
                }
            });

            for (int i = 0; i < nums1.length; i++) {
                heap.offer(new int[] { nums1[i], nums2[0], 0 });
            }
            for (int i = 0; i < k && !heap.isEmpty(); i++) {
                int[] tmp = heap.poll();
                res.add(new int[] { tmp[0], tmp[1] });
                if (tmp[2] + 1 < nums2.length) {
                    heap.offer(new int[] { tmp[0], nums2[tmp[2] + 1], tmp[2] + 1 });
                }
            }
            return res;
        }
    }
    
    public class Solution2 {
        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
            List<int[]> res = new ArrayList<>();
            if(nums1.length==0 || nums2.length==0 || k==0) return res;
            for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
            while(k-- > 0 && !que.isEmpty()){
                int[] cur = que.poll();
                res.add(new int[]{cur[0], cur[1]});
                if(cur[2] == nums2.length-1) continue;
                que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
            }
            return res;
        }
    }
}
