package src.com.Java;

/*
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
你允许：
    装满任意一个水壶
    清空任意一个水壶
    从一个水壶向另外一个水壶倒水，直到装满或者倒空
示例 1: (From the famous "Die Hard" example)
输入: x = 3, y = 5, z = 4
输出: True
 */
public class _365_Water_and_Jug_Problem_水壶问题 {
    /*
    z = m * x + n * y
    4 = (-2) * 3 + 2 * 5, which means you pour in water twice with cup-5 and pour out water twice with cup-3.
    first fill jug-5, pour water to jug-3 from jug-5, empty jug-3, pour the remaining 2 water into jug-3 from jug-5,
    fill jug-5 again, pour water into jug-3 from jug-5, empty jug-3, then we have only 4 water left in jug-5.
    It's exactly fill jug-5 twice and empty jug-3 twice.
     */
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            //limit brought by the statement that water is finallly in one or both buckets
            if (x + y < z)
                return false;
            //case x or y is zero
            if (x == z || y == z || x + y == z)
                return true;
            //get GCD, then we can use the property of Bézout's identity
            return z % GCD(x, y) == 0;
        }

        public int GCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }
}
