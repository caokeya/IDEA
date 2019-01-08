package src.com.Java;

/*
给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。
也就是说，每次移动后你的方位会发生逆时针变化。编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。
示例 1:
输入: [2,1,1,2]
?????
?   ?
???????>
    ?
输出: true 
解释: 路径交叉了
 */
public class _335_Self_Crossing_路径交叉_难 {
    // Categorize the self-crossing scenarios, there are 3 of them:
    // 1. Fourth line crosses first line and works for fifth line crosses second line and so on...
    // 2. Fifth line meets first line and works for the lines after
    // 3. Sixth line crosses first line and works for the lines after
    public class Solution {
        public boolean isSelfCrossing(int[] x) {
            int length = x.length;
            if (length <= 3)
                return false;

            for (int i = 3; i < length; i++) {
                if (x[i] >= x[i - 2] &&
                    x[i - 1] <= x[i - 3])
                    return true; // Fourth line crosses first line and onward
                if (i >= 4) {
                    if (x[i - 1] == x[i - 3] &&
                        x[i] + x[i - 4] >= x[i - 2])
                        return true; // Fifth line meets first line and onward
                }
                if (i >= 5) {
                    if (x[i - 2] - x[i - 4] >= 0 &&
                        x[i] >= x[i - 2] - x[i - 4] &&
                        x[i - 1] >= x[i - 3] - x[i - 5] &&
                        x[i - 1] <= x[i - 3])
                        return true; // Sixth line crosses first line and onward
                }
            }
            return false;
        }
    }
}
