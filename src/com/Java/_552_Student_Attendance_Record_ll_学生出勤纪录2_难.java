package src.com.Java;

/*
给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 10^9 + 7的值。
学生出勤记录是只包含以下三个字符的字符串：
    'A' : Absent，缺勤
    'L' : Late，迟到
    'P' : Present，到场
如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
示例 1:
输入: n = 2
输出: 8 
解释：
有8个长度为2的记录将被视为可奖励：
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
只有"AA"不会被视为可奖励，因为缺勤次数超过一次。
 */
/*
先将A排除在外， 只考虑P和L。那么此时就只有以下3种情况：
以P结尾
以PL结尾
以PLL结尾
所有的合法组合中，肯定符合这三种情况的一种。这样我们就可以进行递归操作了，去除这些结尾后，剩下的字串也是符合这三种情况的，再将结尾去掉，判断剩下的字串… 
用公式来表达，就是： 
dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

将A插入进排列
∑dp[i] *dp[n-1-i] i = 0,1,...,n-1 
For n=3, it becomes dp0dp2+dp1dp1+dp2dp0, When you place A at pos1, then P&L can be placed in dp0dp2 ways.
当n = 3时，假若A放在pos1的位置上，那么P和L有dp[0] * dp[2]种摆法。同理，A放在pos2的位置上时，左边还有俩空，所以有dp[2]种摆法，右边没位置了，
所以有dp[0]个摆法，此时一共有dp[2] * dp[0]个摆法…将A所有的位置遍历一遍后，就将有A的所有组合算出来了。 
 */
public class _552_Student_Attendance_Record_ll_学生出勤纪录2_难 {
    class Solution {
        static final int M = 1000000007;

        public int checkRecord(int n) {
            long[] PorL = new long[n + 1]; // ending with P or L, no A
            long[] P = new long[n + 1]; // ending with P, no A
            PorL[0] = P[0] = 1;
            PorL[1] = 2;
            P[1] = 1;

            for (int i = 2; i <= n; i++) {
                P[i] = PorL[i - 1];
                PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
            }

            long res = PorL[n];
            for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
                long s = (PorL[i] * PorL[n - i - 1]) % M;
                res = (res + s) % M;
            }

            return (int) res;
        }
    }

    class Solution2 {
        public int checkRecord(int n) {
            if (n == 0)
                return 0;
            if (n == 1)
                return 3;
            if (n == 2)
                return 8;

            int m = 1000000007;
            int[] A = new int[n];
            int[] P = new int[n];
            int[] L = new int[n];

            P[0] = 1;
            L[0] = 1;
            L[1] = 3;
            A[0] = 1;
            A[1] = 2;
            A[2] = 4;

            for (int i = 1; i < n; i++) {
                P[i] = ((A[i - 1] + P[i - 1]) % m + L[i - 1]) % m;

                if (i > 1)
                    L[i] = ((A[i - 1] + P[i - 1]) % m + (A[i - 2] + P[i - 2]) % m) % m;

                if (i > 2)
                    A[i] = ((A[i - 1] + A[i - 2]) % m + A[i - 3]) % m;
            }

            return ((A[n - 1] % m + P[n - 1] % m) % m + L[n - 1] % m) % m;
        }
    }
}
