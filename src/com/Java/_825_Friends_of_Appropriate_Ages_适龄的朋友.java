package src.com.Java;

/*
人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：
    age[B] <= 0.5 * age[A] + 7
    age[B] > age[A]
    age[B] > 100 && age[A] < 100
否则，A 可以给 B 发送好友请求。
注意如果 A 向 B 发出了请求，不等于 B 接受了 A 的请求。而且，人们不会给自己发送好友请求。 
求总共会发出多少份好友请求?
示例 1:
输入: [16,16]
输出: 2
解释: 二人可以互发好友申请。
示例 2:
输入: [16,17,18]
输出: 2
解释: 好友请求可产生于 17 -> 16, 18 -> 17.
示例 3:
输入: [20,30,100,110,120]
输出: 3
解释: 好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
 */
public class _825_Friends_of_Appropriate_Ages_适龄的朋友 {
    class Solution {
        public int numFriendRequests(int[] ages) {
            int res = 0;
            int[] numInAge = new int[121];
            int[] sumInAge = new int[121];
            for (int age : ages)
                numInAge[age]++;
            for (int i = 1; i <= 120; i++)
                sumInAge[i] = sumInAge[i - 1] + numInAge[i];

            for (int i = 15; i <= 120; i++) {
                if (numInAge[i] == 0)
                    continue;
                int count = sumInAge[i] - sumInAge[i / 2 + 7];
                res += (count - 1) * numInAge[i];
            }
            return res;
        }
    }
}
