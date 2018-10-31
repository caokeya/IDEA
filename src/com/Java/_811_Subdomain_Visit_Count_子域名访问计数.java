package src.com.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。
作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。
当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
示例 1:
输入: 
["9001 discuss.leetcode.com"]
输出: 
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
说明: 
例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
示例 2
输入: 
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
输出: 
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
说明: 
按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
 */
public class _811_Subdomain_Visit_Count_子域名访问计数 {
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (String cd : cpdomains) {
                int i = cd.indexOf(' ');
                int n = Integer.valueOf(cd.substring(0, i));
                String s = cd.substring(i + 1);
                for (i = 0; i < s.length(); ++i) {
                    if (s.charAt(i) == '.') {
                        String d = s.substring(i + 1);
                        map.put(d, map.getOrDefault(d, 0) + n);
                    }
                }
                map.put(s, map.getOrDefault(s, 0) + n);
            }

            List<String> res = new ArrayList<String>();
            for (String d : map.keySet())
                res.add(map.get(d) + " " + d);
            return res;
        }
    }
}
