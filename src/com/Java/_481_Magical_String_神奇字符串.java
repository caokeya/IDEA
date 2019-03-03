package com.Java;

/*
神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：
字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。
字符串 S 的前几个元素如下：S = “1221121221221121122 ......”
如果我们将 S 中连续的 1 和 2 进行分组，它将变成：
1 22 11 2 1 22 1 22 11 2 11 22 ......
并且每个组中 '1' 或 '2' 的出现次数分别是：
1 2 2 1 1 2 1 2 2 1 2 2 ......
你可以看到上面的出现次数就是 S 本身。
给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。
注意：N 不会超过 100,000。
示例：
输入：6
输出：3
解释：神奇字符串 S 的前 6 个元素是 “12211”，它包含三个 1，因此返回 3。
 */
public class _481_Magical_String_神奇字符串 {
    class Solution {
        public int magicalString(int n) {
            if (n <= 0)
                return 0;
            if (n <= 3)
                return 1;
            int[] nums = new int[n + 1];
            nums[0] = 1;
            nums[1] = 2;
            nums[2] = 2;
            int i = 2;
            int j = 3;
            int num = 1;
            int res = 1;
            while (j < n) {
                for (int temp = 0; temp < nums[i]; temp++) {
                    if (j < n) {
                        nums[j] = num;
                        if (num == 1 && j < n) {
                            res++;
                        }
                        j++;
                    }
                }

                num = num == 1 ? 2 : 1;
                i++;

            }
            return res;
        }
    }
    
    class Solution2 {
        public int magicalString(int n) {
                StringBuilder magic = new StringBuilder("1221121221221121122");
                int pt1 = 12, pt2 = magic.length(), count = 0; //initiate pointers
                //generate sequence directly
                while(magic.length() < n){
                    if(magic.charAt(pt1) == '1'){
                        if(magic.charAt(pt2-1) == '1') magic.append(2);
                        else magic.append(1);
                        pt2++;
                    }else{ //==2
                        if(magic.charAt(pt2-1) == '1') magic.append(22);
                        else magic.append(11);
                        pt2+=2;
                    }
                    pt1++;
                }
                for(int i=0;i<n;i++)
                    if(magic.charAt(i)=='1') count++;
                return count;
            }
        }


}
