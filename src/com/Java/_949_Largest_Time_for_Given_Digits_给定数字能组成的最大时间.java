package src.com.Java;

/*
给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
示例 1：
输入：[1,2,3,4]
输出："23:41"
示例 2：
输入：[5,5,5,5]
输出：""
 */
public class _949_Largest_Time_for_Given_Digits_给定数字能组成的最大时间 {
    class Solution {
        public String largestTimeFromDigits(int[] A) {
            String res = "";

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        int l = 6 - i - j - k;
                        if (i == j || i == k || j == k)
                            continue;
                        String h = "" + A[i] + A[j];
                        String m = "" + A[k] + A[l];
                        String time = h + ":" + m;
                        if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && res.compareTo(time) < 0)
                            res = time;
                    }
                }
            }

            return res;
        }
    }
}
