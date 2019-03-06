package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。
你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。
举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符.
请返回一个能打开保险箱的最短字符串。
示例1:
输入: n = 1, k = 2
输出: "01"
说明: "10"也可以打开保险箱。
示例2:
输入: n = 2, k = 2
输出: "00110"
说明: "01100", "10011", "11001" 也能打开保险箱。
 */
public class _753_Cracking_the_Safe_破解保险柜_难 {
    class Solution {
        public String crackSafe(int n, int k) {
            StringBuilder sb = new StringBuilder();
            int total = (int) (Math.pow(k, n));
            // 首先得到初始化的长度为n的sequence -> 全为0
            for (int i = 0; i < n; i++)
                sb.append('0');
            // 建立visited数组，一旦我们全部遍历过，就说明我们得到了一个字符串
            Set<String> visited = new HashSet<>();
            visited.add(sb.toString());
            // 遍历所有情况
            dfs(sb, total, visited, n, k);

            return sb.toString();
        }

        private boolean dfs(StringBuilder sb, int goal, Set<String> visited, int n, int k) {
            if (visited.size() == goal)
                return true;
            // 每次prev要删掉前面的n-1个字符
            String prev = sb.substring(sb.length() - n + 1, sb.length());
            for (int i = 0; i < k; i++) {
                String next = prev + i;
                if (!visited.contains(next)) {
                    visited.add(next);
                    sb.append(i);
                    if (dfs(sb, goal, visited, n, k))
                        return true;
                    else {
                        visited.remove(next);
                        sb.delete(sb.length() - 1, sb.length());
                    }
                }
            }
            return false;
        }

    }
}
