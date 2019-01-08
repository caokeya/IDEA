package src.com.Java;

/*
你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
给定一个数字 n，找出可形成完整阶梯行的总行数。
n 是一个非负整数，并且在32位有符号整型的范围内。
示例 1:
n = 5
硬币可排列成以下几行:
¤
¤ ¤
¤ ¤
因为第三行不完整，所以返回2.
 */
public class _441_Arranging_Coins_排列硬币 {
    class SolutionMath {
        /*
         * sum = (x + 1) * x / 2
         * so for this problem, if we know the the sum, then we can know the x = (-1 + sqrt(8 * n + 1)) / 2
         */
        public int arrangeCoins(int n) {
            return (int) ((Math.sqrt(8.0 * n + 1) - 1) / 2);
        }
    }

    class Solution {
        public int arrangeCoins(int n) {
            if(n == 0) return 0;
            int i = 1;
            int res = 0;
            while(n > 0){
                n -= i;
                if(n < 0){
                    res =  i - 1;
                }else if(n == 0){
                    res = i;
                }
                i++;
            }
            return res;
        }
    }
}
