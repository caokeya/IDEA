package com.company;

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
