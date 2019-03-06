package src.com.Java;

/*
给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
重复出现的子串要计算它们出现的次数。
示例 1 :
输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
请注意，一些重复出现的子串要计算它们出现的次数。
另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
示例 2 :
输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 */
public class _696_Count_Binary_Substrings_计数二进制子串 {
    /*
     prevCount计算相同的项之前发生(让说你有0011,预试= 2当你遇到第一个1时,意味着有两个0之前第一个' 1 ')
     currentCount计算当前条目的数量(我们说你有0011,curRun = 2当你遇到第二个1,意味着有两个1 s到目前为止)
           每当项目更改(从0到1或从1到0)，preRun更改为curRun, reset curRun to 1(将curRun编号存储到preRun, reset curRun)
           每次pre - un >= curRun就意味着1之前有更多的0,count++也可以。(这是一个棘手的问题，例如，当你打第一个1的时候，curRun = 1, preRun = 2，表示0比1大，
           所以我们现在可以形成01,count++。当你点击第二个“1”时，curRun = 2, preRun = 2，表示0 '等于1'，所以我们现在可以形成"0011"，这就是count++的原因
     */
    class Solution {
        public int countBinarySubstrings(String s) {
            if (s == null || s.isEmpty())
                return 0;
            int prevCount = 0, currentCount = 1;
            int result = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1))
                    currentCount++;
                else {
                    prevCount = currentCount;
                    currentCount = 1;
                }
                if (currentCount <= prevCount)
                    result++;
            }
            return result;
        }
    }
}
