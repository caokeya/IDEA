package src.com.Java;
/*
你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
示例 :
输入: a = 2, b = [1,0]
输出: 1024
 */
public class _372_Super_Pow_超级次方 {
    public class Solution {
        /*
         先验知识: a^(b*c) %m = a^b %m ^c %m
        */
        public int superPow(int a, int[] b) {
            return superPowerSub(a, b, b.length-1);
        }
        
        /* 递归方法
        a^[1,2,3,4] = pow(a^[1,2,3], 10) * pow(a, 4)
        a^[1,2,3] = pow(a^[1,2], 10) * pow(a, 3)
        a^[1,2] = pow(a^[1], 10) * pow(a, 2)
        a^[1] = pow(a, 1)
        */
        public int superPowerSub(int a, int[] b, int index) {
            if (index == 0)
                return pow(a, b[index]) % 1337;
            int pre = superPowerSub(a, b, index-1);
            return (pow(pre, 10) * pow(a, b[index])) % 1337;
        }
        
        /*
        x 的n次方，这里n都是个位数
        */
        public int pow(int x, int n) {
            if (n == 0)
                return 1;
            if (n == 1)
                return x % 1337;
            int half = pow(x, n/2); 
            if(n%2==0)  
                return (half*half) % 1337;  // half是递归传回来的，不会大于1337
            else  
                return (((half*half) % 1337) *(x % 1337)) % 1337; 
        }
    }
}
