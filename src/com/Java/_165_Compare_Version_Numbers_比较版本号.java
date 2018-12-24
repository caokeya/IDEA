package src.com.Java;

/*
比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
你可以假设版本字符串非空，并且只包含数字和 . 字符。
 . 字符不代表小数点，而是用于分隔数字序列。
示例 1:
输入: version1 = "0.1", version2 = "1.1"
输出: -1
示例 2:
输入: version1 = "1.0.1", version2 = "1"
输出: 1
示例 3:
输入: version1 = "7.5.2.4", version2 = "7.5.3"
输出: -1
 */
public class _165_Compare_Version_Numbers_比较版本号 {
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int n = Math.max(v1.length, v2.length);
            for (int i = 0; i < n; i++) {
                int k = i < v1.length ? Integer.parseInt(v1[i]) : 0;
                int j = i < v2.length ? Integer.parseInt(v2[i]) : 0;
                if (k > j)
                    return 1;
                else if (k < j)
                    return -1;
                else
                    continue;
            }
            return 0;
        }
    }
}
