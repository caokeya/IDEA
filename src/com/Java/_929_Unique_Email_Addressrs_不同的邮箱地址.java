package src.com.Java;

import java.util.HashSet;
import java.util.Set;

/*
每封电子邮件由一个本地名称和一个域名组成，以@符号分隔。
例如，在alice@leetcode.com中，alice是本地名，leetcode.com是域名。
除了小写字母，这些邮件还可能包含' '。”或“+”。
如果您在电子邮件地址的本地名称部分的某些字符之间添加句点('.')，那么发送到那里的邮件将被转发到相同的地址，而本地名称中没有点号。
例如，“alice.z@leetcode.com”和“alicez@leetcode.com”转发到相同的电子邮件地址。(请注意，此规则不适用于域名。)
如果在本地名称中添加加号('+')，第一个加号后面的所有内容都将被忽略。
这允许某些电子邮件被过滤，例如m.y+name@email.com将被转发到my@email.com。(同样，这条规则不适用于域名。)
同时使用这两个规则是可能的。
给定一个电子邮件列表，我们向列表中的每个地址发送一封电子邮件。有多少不同的地址实际接收邮件?
 */

public class _929_Unique_Email_Addressrs_不同的邮箱地址 {
    class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> seen = new HashSet();
            for (String email : emails) {
                int i = email.indexOf('@');
                String local = email.substring(0, i);
                String rest = email.substring(i);
                if (local.contains("+")) {
                    local = local.substring(0, local.indexOf('+'));
                }
                local = local.replaceAll(".", "");
                seen.add(local + rest);
            }

            return seen.size();
        }
    }
}
