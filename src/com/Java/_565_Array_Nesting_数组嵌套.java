package src.com.Java;

/*
索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
示例 1:
输入: A = [5,4,0,3,1,6,2]
输出: 4
解释: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
其中一种最长的 S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 */
public class _565_Array_Nesting_数组嵌套 {
    /*
    使用已访问的映射来跟踪已访问的节点。如果之前访问过一个数字，那么从这个数字开始的集合一定会更小。
    所以我们可以安全地跳过这个数字。总的来说是O(n)的复杂度
     */
    class Solution {
        public int arrayNesting(int[] nums) {
            int ans = 0;
            int n = nums.length;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                int cur = i;
                int len = 0;
                while (!visited[cur]) {
                    len++;
                    visited[cur] = true;
                    cur = nums[cur];
                }
                ans = Math.max(ans, len);
            }
            return ans;
        }
    }
}
