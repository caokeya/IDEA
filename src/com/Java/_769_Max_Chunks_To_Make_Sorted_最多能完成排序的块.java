package src.com.Java;

/*
数组arr是[0, 1, ..., arr.length - 1]的一种排列，不可重复，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
我们最多能将数组分成多少块？
示例 1:
输入: arr = [4,3,2,1,0]
输出: 1
解释:
将数组分成2块或者更多块，都无法得到所需的结果。
例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
示例 2:
输入: arr = [1,0,2,3,4]
输出: 4
解释:
我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 */
public class _769_Max_Chunks_To_Make_Sorted_最多能完成排序的块 {
    /*
           基本思想是使用max[] array来跟踪最大值直到当前位置，并将其与排序的数组(索引从0到arr)进行比较。如果max[i]等于排序数组中索引i处的元素，那么最终计数++
     original: 0, 2, 1, 4, 3, 5, 7, 6
     max:      0, 2, 2, 4, 4, 5, 7, 7
     sorted:   0, 1, 2, 3, 4, 5, 6, 7
     index:    0, 1, 2, 3, 4, 5, 6, 7
     The chunk 0| 2, 1| 4, 3| 5| 7, 6
     */
    class Solution {
        public int maxChunksToSorted(int[] arr) {

            if (arr == null || arr.length == 0) {
                return 0;
            }
            int[] max = new int[arr.length];
            max[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                max[i] = Math.max(arr[i], max[i - 1]);
            }
            int count = 0;
            for (int i = 0; i < max.length; i++) {
                if (max[i] == i) {
                    count++;
                }
            }
            return count;
        }
    }
}
