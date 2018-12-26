package src.com.Java;

/*
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
假设只有一个重复的整数，找出这个重复的数。
示例 1:
输入: [1,3,4,2,2]
输出: 2
示例 2:
输入: [3,1,3,4,2]
输出: 3
说明：
    不能更改原数组（假设数组是只读的）。
    只能使用额外的 O(1) 的空间。
    时间复杂度小于 O(n2) 。
    数组中只有一个重复的数字，但它可能不止重复出现一次。
*/
public class _287_Find_the_Duplicate_Number_寻找重复数字 {
    class Solution {
        //*************Method 1****************
        // //idea: sort and traverse
        // //time: o(nlogn)
        // //space: O(1)
        // public int findDuplicate(int[] nums) {
        //     Arrays.sort(nums);
        //     for(int i = 1 ; i < nums.length; i++){
        //         if(nums[i] == nums[i - 1]){
        //             return nums[i];
        //         }
        //     }
        //     return -1;
        // }

        //****************Method 2****************
        // //idea: put elements into hash set
        // //time: O(n)
        // //space: O(n)
        // public int findDuplicate(int[] nums) {
        //     Set<Integer> set = new  HashSet<>();
        //     for(int i : nums){
        //         if(set.contains(i)){
        //             return i;
        //         }
        //         set.add(i);
        //     }
        //     return -1;
        // }

        //*************Method 3*******************
        //floyd's tortoise and hare(cycle detection)
        //time:O(n)
        //space：O(1)
        /*
        使用两个指针，快的和慢的。快的每次前进两步，慢的每次只前进一步。当慢=快时，它们必须遇到相同的项目。
        实际上，它们在一个圆中相交，当从nums[0]访问数组时，重复的数字必须是圆的入口点。接下来我们只需要找到入口点。
        我们用一个点(我们可以用前面快的那个点)来访问表单，每次从一个步骤开始，做同样的工作来慢下来。当快==慢时，它们在圆的入口相遇。
         */
        //两次找到同一个位置即我们要的位置
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[0];

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            int ptr1 = nums[0];
            int ptr2 = slow;

            while (ptr1 != ptr2) {
                ptr1 = nums[ptr1];
                ptr2 = nums[ptr2];
            }
            return ptr1;
        }

        //将原来的值变成负数，当再次找到这个位置即我们要的位置
        public int findDuplicateReserve(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0) {
                    return index + 1;
                } else {
                    nums[index] = -nums[index];
                }
            }
            return -1;
        }
    }
}


