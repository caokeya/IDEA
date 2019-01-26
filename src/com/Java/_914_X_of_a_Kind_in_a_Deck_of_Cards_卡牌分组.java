package src.com.Java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
给定一副牌，每张牌上都写着一个整数。
此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
    每组都有 X 张牌。
    组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。
示例 1：
输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
示例 2：
输入：[1,1,1,2,2,2,3,3]
输出：false
解释：没有满足要求的分组。
示例 3：
输入：[1]
输出：false
解释：没有满足要求的分组。
示例 4：
输入：[1,1]
输出：true
解释：可行的分组是 [1,1]
示例 5：
输入：[1,1,2,2,2,2]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[2,2]
 */
public class _914_X_of_a_Kind_in_a_Deck_of_Cards_卡牌分组 {
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int d : deck) {
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            int res = 0;
            for (int v : map.values()) {
                res = gcd(res, v);
            }
            return res > 1;
        }

        public int gcd(int a, int b) {// 最小公因数
            if (a == 0)
                return b;
            return gcd(b % a, a);
        }
    }
}
