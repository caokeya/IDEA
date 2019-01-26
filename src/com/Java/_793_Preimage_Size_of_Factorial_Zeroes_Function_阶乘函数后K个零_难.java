package src.com.Java;

/*
f(x) 是 x! 末尾是0的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且0! = 1）
例如， f(3) = 0 ，因为3! = 6的末尾没有0；而 f(11) = 2 ，因为11!= 39916800末端有2个0。
给定 K，找出多少个非负整数x ，有 f(x) = K 的性质。
示例 1:
输入:K = 0
输出:5
解释: 0!, 1!, 2!, 3!, and 4! 均符合 K = 0 的条件。
示例 2:
输入:K = 5
输出:0
解释:没有匹配到这样的 x!，符合K = 5 的条件。
 */
public class _793_Preimage_Size_of_Factorial_Zeroes_Function_阶乘函数后K个零_难 {
    class Solution {
        public int preimageSizeFZF(int K) {
            long low = K;
            long high = (long) 5 * K + 1;

            while (low < high) {
                long mid = low + (high - low) / 2;
                int c = count(mid);
                if (c == K) {
                    return 5;
                } else if (c > K) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return 0;
        }

        public int count(long n) {
            int count = 0;
            while (n != 0) {
                n /= 5;
                count += n;
            }

            return count;
        }
    }

    class Solution2 {
        public int preimageSizeFZF(int K) {
            /*
            findRange(K)- All elements factorial <= Kzeroes findRange(K-1) -All elements
            factorial <= K-1 zeroes
            */
            return (int) (getLargestNumberHavingKZero(K) - getLargestNumberHavingKZero(K - 1));
        }

        // Using Binary Search
        private long getLargestNumberHavingKZero(int k) {
            long l = 0, r = 5 * (k + 1);
            while (l < r) {
                long mid = l + (r - l) / 2;
                int zeros = numOfZero(mid);
                if (zeros > k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }

        // get zeroes in N!
        private int numOfZero(long x) {
            int ret = 0;
            for (; x > 0; x /= 5) {
                ret += x / 5;
            }
            return ret;
        }
    }
}
