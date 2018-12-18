package src.com.Java;

/**
* @author  suzw
* @version 创建时间：2018年9月4日 下午1:14:15 
* 类说明 
* 关键点: 使用筛选法判断是否是素数，使用数组存储，初始化为false
* 可以缩短时间
* 后附另两种方法：快速12ms，普通方法-超时 
* 可参考：https://www.2cto.com/kf/201805/743532.html
*/
public class _204_Count_Primes_统计质数的个数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(10000));
		
	}
	//筛选法
	public static int  countPrimes(int n) {
		int ans = 0;
		boolean[] notPrime = new boolean[n];
		for(int i = 2;i<n;i++) {
			if (notPrime[i] == false) {
				ans++;
				for(int j =2;i*j<n;j++) {
					notPrime[i*j] = true;
				}
				
			}
		}
		return ans;
		
	}
		//leetcode-12ms的方法
		public int countPrimesFast(int n) {
        
        /**
         * if n = 2, the prime 2 is not less than n,
         * so there are no primes less than n
         */
        if (n < 3) return 0;
        
        /** 
         * Start with the assumption that half the numbers below n are
         * prime candidates, since we know that half of them are even,
         * and so _in general_ aren't prime.
         * 
         * An exception to this is 2, which is the only even prime.
         * But also 1 is an odd which isn't prime.
         * These two exceptions (a prime even and a for-sure not-prime odd)
         * cancel each other out for n > 2, so our assumption holds.
         * 
         * We'll decrement count when we find an odd which isn't prime.
         *
         * If n = 3,  c = 1.
         * If n = 5,  c = 2.
         * If n = 10, c = 5.
         */
        int c = n / 2;
        
        /**
         * Java initializes boolean arrays to {false}.
         * In this method, we'll use truth to mark _composite_ numbers.
         * 
         * This is the opposite of most Sieve of Eratosthenes methods,
         * which use truth to mark _prime_ numbers.
         * 
         * We will _NOT_ mark evens as composite, even though they are.
         * This is because `c` is current after each `i` iteration below.
         */
        boolean[] s = new boolean[n];
        
        /**
         * Starting with an odd prime-candidate above 2, increment by two
         * to skip evens (which we know are not prime candidates).
         */
        for (int i = 3; i * i < n; i += 2) {
            if (s[i]) {
                // c has already been decremented for this composite odd
                continue;
            }
            
            /** 
             * For each prime i, iterate through the odd composites
             * we know we can form from i, and mark them as composite
             * if not already marked.
             * 
             * We know that i * i is composite.
             * We also know that i * i + i is composite, since they share
             * a common factor of i.
             * Thus, we also know that i * i + a*i is composite for all real a,
             * since they share a common factor of i.
             * 
             * Note, though, that i * i + i _must_ be composite for an
             * independent reason: it must be even.
             * (all i are odd, thus all i*i are odd,
             * thus all (odd + odd) are even).
             * 
             * Recall that, by initializing c to n/2, we already accounted for
             * all of the evens less than n being composite, and so marking
             * i * i + (odd)*i as composite is needless bookkeeping.
             * 
             * So, we can skip checking i * i + a*i for all odd a,
             * and just increment j by even multiples of i,
             * since all (odd + even) are odd.
             */
            for (int j = i * i; j < n; j += 2 * i) {
                if (!s[j]) {
                    c--;
                    s[j] = true;
                    }
                }
            }
        return c;
    }

	//常规方法，会超时
	public static int countPrimesBasic(int n) {
		int ans = 0;
		int i = 2;
		while(i<n) {
			ans += isPrimeNumber(i) ? 1:0;
			i++;
		}
		return ans;
		
	}
	public static boolean isPrimeNumber(int num) {
		int i = 2;
		if (num%i == 0) {
			return false;
		}
		i++;
		while(i<= Math.sqrt(num)) {
			if (num%i == 0) {
				return false;
			}
			i+=2;
		}
		return true;
	}

}
