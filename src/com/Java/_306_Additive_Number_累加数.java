package src.com.Java;

/*
累加数是一个字符串，组成它的数字可以形成累加序列。
一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
示例 1:
输入: "199100"
输出:  true 
解释: 累加序列为: 1, 99, 100, 。1 + 99 = 100, 
 */
public class _306_Additive_Number_累加数 {
    class Solution {
        public boolean isAdditiveNumber(String s) {
            int n = s.length();
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    long a = parse(s.substring(0, i));//1
                    long b = parse(s.substring(i, j));//99
                    if (a == -1 || b == -1)
                        continue;
                    if (dfs(s.substring(j), a, b))//substring(i)删去字符串开头的i个字符
                        return true;
                }
            }
            return false;
        }

        public boolean dfs(String s, long a, long b) {//s=100
            if (s.length() == 0)
                return true;
            for (int i = 1; i <= s.length(); i++) {
                long c = parse(s.substring(0, i));
                if (c == -1)
                    continue;
                if (c - a == b && dfs(s.substring(i), b, c))
                    return true;
            }
            return false;
        }

        public long parse(String s) {
            if (!s.equals("0") && s.startsWith("0"))
                return -1;
            return Long.parseLong(s);
        }
    }

    class Solution2 {
        public boolean isAdditiveNumber(String num) {
            int L = num.length();
            for (int i = 1; i <= (L - 1) / 2; i++) {
                if (num.charAt(0) == '0' && i >= 2) break;
                for (int j = i + 1; L - j >= j - i && L - j >= i; j++) {
                    if (num.charAt(i) == '0' && j >= i + 2) break;
                    long num1 = Long.parseLong(num.substring(0, i));
                    long num2 = Long.parseLong(num.substring(i, j));
                    String substr = num.substring(j);
                    if (isAdditive(substr, num1, num2)) return true;
                }
            }
            return false;
        }

        public boolean isAdditive(String substr, long num1, long num2) {
            if (substr.equals("")) return true;
            long sum = num1 + num2;
            String s = sum + "";
            if (!substr.startsWith(s)) return false;
            return isAdditive(substr.substring(s.length()), num2, sum);
        }
    }
}
