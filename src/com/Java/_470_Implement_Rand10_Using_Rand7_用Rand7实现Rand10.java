package src.com.Java;
/*
已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
不要使用系统的 Math.random() 方法。
示例 1:
输入: 1
输出: [7]
示例 2:
输入: 2
输出: [8,4]
 */
public class _470_Implement_Rand10_Using_Rand7_用Rand7实现Rand10 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */
    class Solution extends SolBase {
        public int rand10() {
            int result = 40;
            while (result >= 40) {
                result = 7 * (rand7() - 1) + (rand7() - 1);
            }
            return result % 10 + 1;
        }
    }
}
