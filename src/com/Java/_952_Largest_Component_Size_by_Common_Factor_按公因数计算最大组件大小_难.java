package src.com.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给定一个由不同正整数的组成的非空数组 A，考虑下面的图：
    有 A.length 个节点，按从 A[0] 到 A[A.length - 1] 标记；
    只有当 A[i] 和 A[j] 共用一个大于 1 的公因数时，A[i] 和 A[j] 之间才有一条边。
返回图中最大连通组件的大小。
示例 1：
输入：[4,6,15,35]
输出：4
示例 2：
输入：[20,50,9,63]
输出：2
示例 3：
输入：[2,3,6,7,4,12,21,39]
输出：8
 */
public class _952_Largest_Component_Size_by_Common_Factor_按公因数计算最大组件大小_难 {
    /*
    计算所有小于100000的素数。
    对于A中的每个数，我们说A[i]
    a.做质因数分解(使用步骤1中设置的素数进行蛮力分解)，我们说质因数是p。
    b.如果p出现在primeToIndex、union i和primeToIndex中[p]。
    c.将primeToIndex[p]更新到i。
    返回最大计数。
     */
    class Solution {
        int max = 0;
        public int largestComponentSize(int[] A) {
            boolean[] isPrime = new boolean[100001];
            Arrays.fill(isPrime, true);
            Set<Integer> primes = new HashSet<>();
            // all primes less than 100000
            for (int i = 2; i <= 100000; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                    for (int j = 2; j * i <= 100000; j++) {
                        isPrime[j * i] = false;
                    }
                }
            }
            int n = A.length;
            int[] counts = new int[n];
            int[] parents = new int[n];
            int[] primeToIndex = new int[100001];
            Arrays.fill(primeToIndex, -1);
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                counts[i] = 1;
            }
            for (int i = 0; i < n; i++) {
                int a = A[i];
                for (int p : primes) {
                    if (primes.contains(a)) { // Optimization
                        p = a;
                    }
                    if (a % p == 0) {
                        if (primeToIndex[p] > -1) {
                            union(parents, counts, primeToIndex[p], i);
                        }
                        primeToIndex[p] = i;
                        while (a % p == 0) {
                            a /= p;
                        }
                    }
                    if (a == 1) {
                        break;
                    }
                }
            }
            return max;
        }

        private int find(int[] parents, int a) {
            if (parents[a] != a) {
                parents[a] = find(parents, parents[a]);
            }
            return parents[a];
        }

        private void union(int[] parents, int[] counts, int a, int b) {
            int root1 = find(parents, a), root2 = find(parents, b);
            if (root1 == root2) {
                return;
            }
            int count = counts[root2] + counts[root1];
            max = Math.max(count, max);
            parents[root1] = root2;
            counts[root2] = count;
        }
    }
}
