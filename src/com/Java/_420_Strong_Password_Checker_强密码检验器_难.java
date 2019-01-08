package src.com.Java;

/*
一个强密码应满足以下所有条件：
    由至少6个，至多20个字符组成。
    至少包含一个小写字母，一个大写字母，和一个数字。
    同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；
否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。
插入、删除、替换任一字符都算作一次修改。
 */
public class _420_Strong_Password_Checker_强密码检验器_难 {
    class Solution {
        public int strongPasswordChecker(String s) {
            int n = s.length();
            boolean hasLower = false, hasUpper = false, hasDigit = false;
            int nRep = 0, sum = 0; // sum=sum{length>=3 of a SSRC}
            int[] m = new int[3]; // # of SSRC of length 3k, 3k+1, 3k+2

            int i = 0, j, t;
            char c;
            while (i < n) {
                c = s.charAt(i);

                hasLower |= (c >= 'a' && c <= 'z');
                hasUpper |= (c >= 'A' && c <= 'Z');
                hasDigit |= (c >= '0' && c <= '9');

                j = i + 1;
                while (j < n && s.charAt(j) == c)
                    j++;

                t = j - i;
                if (t >= 3) {
                    nRep += t / 3;
                    sum += t;
                    m[t % 3]++;
                }
                i = j;
            }

            int nMiss = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

            if (n < 6)
                return (6 - n) > nMiss ? (6 - n) : nMiss;

            if (n <= 20)
                return Math.max(nRep, nMiss);

            // n > 20
            int nDel = n - 20;
            if (nDel <= m[0])
                return nDel + Math.max(nRep - nDel, nMiss);

            int rNDel = nDel - m[0];
            nRep -= m[0];
            if (rNDel <= 2 * m[1])
                return nDel + Math.max(nRep - rNDel / 2, nMiss);

            rNDel -= 2 * m[1];
            nRep -= m[1];
            if (nDel <= sum - 2 * (m[0] + m[1] + m[2]))
            /*
             * This condition is equivalent to nDel-m[0]-2m[1]<=sum{3(k_i-1)}+sum{3(k'_i-1)}+sum{3k''_i},
             * where {3k_i, 1<=i<=m[0]}, {3k'_i+1,1<=i<=m[1]}, {3k''_i+2, 1<=i<=m[2]}
             * are the sets of lengths of SSRCs
             */
                return nDel + Math.max(nRep - rNDel / 3, nMiss);

            return nDel + nMiss;
        }
    }
}
