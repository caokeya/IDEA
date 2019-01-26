package src.com.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
返回森林中兔子的最少数量。
示例:
输入: answers = [1, 1, 2]
输出: 5
解释:
两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
设回答了 "2" 的兔子为蓝色。
此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
输入: answers = [10, 10, 10]
输出: 11
输入: answers = []
输出: 0
 */
public class _781_Rabbits_in_Forest_森林中的兔子 {
    /*
    我们统计数组中所有回答x的兔子的数量n：
    若 n%(x+1)==0，说明我们此时只需要 n/(x+1) 组个数为x+1的兔子。
    若 n%(x+1)!=0，说明我们此时只需要 n/(x+1) + 1 组个数为x+1的兔子。
    那么这两种情况可以通过 ceil(n/(x+1))来整合，而这个值也等于 (n + x) / (x + 1).
    if(该数字出现次数 % (喊出的数字+1) == 0) { ans+= 出现次数;//该回答的兔子全在数组内，默认为相同颜色，将该数字加入总数 }
    else{ ans+= (出现次数 % (喊出的数字+1)+1)* (喊出的数字 +1); //如果出现的次数多于或少于兔子所说实际情况，那么数组之外必有其他兔子 }
    */
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : answers)
                map.put(i, map.getOrDefault(i, 0) + 1);
            int res = 0;
            for (int i : map.keySet())
                res += (map.get(i) + i) / (i + 1) * (i + 1);//相当于math.ceil(n / (x + 1)) * (i + 1)
            return res;
        }
    }

    class Solution2 {
        public int numRabbits(int[] a) {
            Arrays.sort(a);
            int total = 0, r = 0;
            for (int i = 0; i < a.length; i++) {
                if (r-- == 0 || a[i] != a[i - 1]) {
                    r = a[i];
                    total += a[i] + 1;
                }
            }
            return total;
        }
    }
}
