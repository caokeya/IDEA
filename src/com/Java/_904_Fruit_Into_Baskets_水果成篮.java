package src.com.Java;

import java.util.HashMap;
import java.util.Map;

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
    /*
    使用滑动窗口迭代数组
    将经过的数字存储到hashmap中
    如果地图的大小大于2，我们从第一个标记的开始
    检查我们能得到的最大水果
    */
    class Solution {
        public int totalFruit(int[] tree) {
            if (tree == null || tree.length == 0)
                return 0;
            int len = tree.length;
            int res = 0, counter = 0, start = 0;
            int[] fruits = new int[tree.length];
            for (int i = 0; i < len; i++) {
                if (fruits[tree[i]]++ == 0) {// 记录同一个数的次数
                    counter++;
                }
                while (counter > 2) {
                    if (fruits[tree[start]]-- == 1) {// 直到一个数的次数为0时，count--
                        counter--;
                    }
                    start++;
                }
                res = Math.max(res, i - start + 1);
            }
            return res;
        }
    }

    class SolutionMap {
        public int totalFruit(int[] tree) {
            Map<Integer, Integer> count = new HashMap<Integer, Integer>();
            int res = 0, i = 0;
            for (int j = 0; j < tree.length; ++j) {
                count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
                while (count.size() > 2) {
                    count.put(tree[i], count.get(tree[i]) - 1);
                    if (count.get(tree[i]) == 0)
                        count.remove(tree[i]);
                    i++;
                }
                res = Math.max(res, j - i + 1);
            }
            return res;
        }
    }
}
