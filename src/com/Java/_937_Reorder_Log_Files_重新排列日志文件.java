package com.Java;

import java.util.Arrays;
import java.util.Comparator;

/*
你有一个日志数组 logs。每条日志都是以空格分隔的字串。
对于每条日志，其第一个字为字母数字标识符。然后，要么：
    标识符后面的每个字将仅由小写字母组成，或；
    标识符后面的每个字将仅由数字组成。
我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按字母顺序排序，忽略标识符，标识符仅用于表示关系。数字日志应该按原来的顺序排列。
返回日志的最终顺序。
示例 ：
输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */
public class _937_Reorder_Log_Files_重新排列日志文件 {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {

            Comparator<String> myComp = new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    int s1si = s1.indexOf(' ');
                    int s2si = s2.indexOf(' ');
                    char s1fc = s1.charAt(s1si + 1);
                    char s2fc = s2.charAt(s2si + 1);
                    if (s1fc <= '9') {
                        if (s2fc <= '9')
                            return 0;
                        else
                            return 1;
                    }
                    if (s2fc <= '9')
                        return -1;
                    int preCompute = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));
                    if (preCompute == 0)
                        return s1.substring(0, s1si).compareTo(s2.substring(0, s2si));
                    return preCompute;
                }
            };
            Arrays.sort(logs, myComp);
            return logs;
        }
    }
}
