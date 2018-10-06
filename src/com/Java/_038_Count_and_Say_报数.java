package src.com.Java;
/*
报数序列是指一个整照其中的整数的顺序进数序列，按行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 */
public class _038_Count_and_Say_报数 {
    class Solution {
        public String countAndSay(int n) {
            String res = "1";
            for (int i = 2; i <= n; i++) {
                StringBuilder sb = new StringBuilder();
                char c = res.charAt(0);
                int count = 0;
                for (int j = 0; j < res.length(); j++) {
                    if (c == res.charAt(j))
                        count++;
                    else {
                        sb.append(count);
                        sb.append(c);
                        c = res.charAt(j);
                        count = 1;
                    }
                }
                sb.append(count);
                sb.append(c);
                res = sb.toString();
            }
            return res;
        }
    }
}
