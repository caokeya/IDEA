package src.com.Java;
/*
在一排树中，第 i 棵树产生 tree[i] 型的水果。
你可以从你选择的任何树开始，然后重复执行以下步骤：
    把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
    移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
用这个程序你能收集的水果总量是多少？
示例 1：
输入：[1,2,1]
输出：3
解释：我们可以收集 [1,2,1]。
示例 2：
输入：[0,1,2,2]
输出：3
解释：我们可以收集 [1,2,2].
如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
示例 3：
输入：[1,2,3,2,2]
输出：4
解释：我们可以收集 [2,3,2,2].
如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
示例 4：
输入：[3,3,3,1,2,1,1,2,3,3,4]
输出：5
解释：我们可以收集 [1,2,1,1,2].
如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 个水果。
 */
public class _904_Fruit_Into_Baskets_水果成篮 {
    class Solution {
        public int totalFruit(int[] tree) {
            if (tree.length == 0)
                return 0;
            int type1 = tree[0], type2 = type1, temp;// type1 type2表示tree【i-1】的值
            int count_type2 = 0, max = 0, count = 0; // count_type2 记录i之前的连续的值为tree[i-1]的个数
            for (int i = 0; i < tree.length; i++) {
                temp = tree[i];
                if (temp == type2) {
                    count++;
                    count_type2++;
                } else if (temp == type1) {
                    count++;
                    count_type2 = 1;
                    type1 = type2;
                    type2 = temp;
                } else {
                    max = Math.max(max, count);
                    count = count_type2 + 1;
                    count_type2 = 1;
                    type1 = type2;
                    type2 = temp;
                }
            }
            max = Math.max(max, count);
            return max;
        }
    }

    class Solution2 {
        public int totalFruit(int[] tree) {

            if (tree.length <= 2)
                return tree.length;

            int maxFruit = 0;

            int start = 0;
            int end = 0;

            while (end < tree.length) {
                int firstFruit = tree[start];
                int secondFruit = -1;
                int lastInstance = -1;
                boolean firstFound = false;

                //as long as we don't exceed the list length, and it's not a 3rd new type of fruit (only two types allowed)
                while (end < tree.length
                        && (secondFruit == -1 || firstFruit == tree[end] || secondFruit == tree[end])) {
                    //if we find a new instance of the second fruit that is after an instance of the first fruit
                    if (tree[end] == secondFruit && firstFound == true) {
                        lastInstance = end;
                        firstFound = false;
                    }
                    //if we find an instance of the first fruit, mark boolean true so that next instance of the second fruit
                    //is our last valid instance to use for next iteration
                    if (tree[end] == firstFruit)
                        firstFound = true;
                    //if it's new and second fruit is available, assign second fruit and make it our last instance of that fruit
                    if (secondFruit == -1 && firstFruit != tree[end]) {
                        secondFruit = tree[end];
                        lastInstance = end;
                        firstFound = false;
                    }
                    end++;
                }
                //decrementing end because we don't want that last increment when the while loop's condition was not met
                end--;
                //updating max fruit found in a subarray if needed
                if (maxFruit < (end - start) + 1)
                    maxFruit = end - start + 1;
                //if we have reached the end of the list, just break it.
                //Any subarray s1 which we consider after s2 which reaches the end of the array will result in s1.length < s2.length
                //Therefore, no point in checking s1. We can save runtime and gain better efficiency by not doing so.
                if (end == tree.length - 1)
                    break;
                /*
                Setting up start and end indices for next iteration.
                
                During the next iteration, our start should be the last instance with the greatest index of the second fruit
                which happens to occur right after an instance of the first fruit so that we can see if the second fruit of this
                iteration can be the first fruit of the next iteration and result in a longer subarray.
                
                Essentially, the second fruit of any iteration is going to be the first fruit of the next iteration so that we 
                do not miss out on any of the possible subarrays
                */
                start = lastInstance;
                end = start + 1;
            }
            return maxFruit;
        }
    }
}
