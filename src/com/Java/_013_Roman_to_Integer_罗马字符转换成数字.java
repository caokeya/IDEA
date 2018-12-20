package src.com.Java;

import java.util.HashMap;
import java.util.Map;

//罗马字符转换成数字
/*
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 */
public class _013_Roman_to_Integer_罗马字符转换成数字 {
    class Solution {
        public int romanToInt(String s) {
            int res = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                switch (c) {
                    case 'I':
                        res += res >= 5 ? -1 : 1;
                        break;
                    case 'V':
                        res += 5;
                        break;
                    case 'X':
                        res += 10 * (res >= 50 ? -1 : 1);
                        // res += res >= 50 ? -10 : 10;
                        break;
                    case 'L':
                        res += 50;
                        break;
                    case 'C':
                        res += 100 * (res >= 500 ? -1 : 1);
                        // res += res >= 500 ? -100 : 100;
                        break;
                    case 'D':
                        res += 500;
                        break;
                    case 'M':
                        res += 1000;
                        break;
                    default:
                        break;
                }
            }

            return res;
        }
    }

    class Solution2 {
        public int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int len = s.length();
            int r = map.get(s.charAt(len - 1));
            for (int i = len - 1; i > 0; i--) {
                int first = map.get(s.charAt(i));
                int second = map.get(s.charAt(i - 1));
                if (second < first) r -= second;
                else r += second;
            }
            return r;
        }
    }
}
