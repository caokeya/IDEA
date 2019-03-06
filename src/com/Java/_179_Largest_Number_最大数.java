package src.com.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1:
输入: [10,2]
输出: 210
示例 2:
输入: [3,30,34,5,9]
输出: 9534330
 */
public class _179_Largest_Number_最大数 {

    public class Solution {
        public String largestNumber(int[] num) {
            StringBuffer sbuf = new StringBuffer();
            ArrayList<String> numstrings = new ArrayList<String>(num.length);

            for (int i : num)
                numstrings.add(String.valueOf(i));
            Collections.sort(numstrings, new StringComparator());

            for (String s : numstrings)
                sbuf.append(s);

            String res = sbuf.toString();
            if (res.length() > 0 && res.charAt(0) == '0')
                return "0";

            return res;
        }
    }

    class StringComparator implements Comparator<String> {
        public int compare(String a, String b) {
            if (a.length() == b.length()) {
                return b.compareTo(a);
            } else {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        }
    }

}
