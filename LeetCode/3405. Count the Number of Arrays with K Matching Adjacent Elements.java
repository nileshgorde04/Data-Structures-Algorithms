/*
3405. Count the Number of Arrays with K Matching Adjacent Elements
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given three integers n, m, k. A good array arr of size n is defined as follows:

Each element in arr is in the inclusive range [1, m].
Exactly k indices i (where 1 <= i < n) satisfy the condition arr[i - 1] == arr[i].
Return the number of good arrays that can be formed.

Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: n = 3, m = 2, k = 1

Output: 4

Explanation:

There are 4 good arrays. They are [1, 1, 2], [1, 2, 2], [2, 1, 1] and [2, 2, 1].
Hence, the answer is 4.
Example 2:

Input: n = 4, m = 2, k = 2

Output: 6

Explanation:

The good arrays are [1, 1, 1, 2], [1, 1, 2, 2], [1, 2, 2, 2], [2, 1, 1, 1], [2, 2, 1, 1] and [2, 2, 2, 1].
Hence, the answer is 6.
Example 3:

Input: n = 5, m = 2, k = 0

Output: 2

Explanation:

The good arrays are [1, 2, 1, 2, 1] and [2, 1, 2, 1, 2]. Hence, the answer is 2.
 

Constraints:

1 <= n <= 105
1 <= m <= 105
0 <= k <= n - 1
*/

//Solution

import java.math.BigInteger;

class Solution {
    static final int MX = 100000;
    static final BigInteger MOD = BigInteger.valueOf(1_000_000_007);
    static final BigInteger[] fact = new BigInteger[MX];
    static final BigInteger[] invFact = new BigInteger[MX];

    static BigInteger qpow(BigInteger x, BigInteger n) {
        BigInteger res = BigInteger.ONE;
        while (n.signum() > 0) {
            if (n.testBit(0)) {
                res = res.multiply(x).mod(MOD);
            }
            x = x.multiply(x).mod(MOD);
            n = n.shiftRight(1);
        }
        return res;
    }

    static void init() {
        if (fact[0] != null) return;
        fact[0] = BigInteger.ONE;
        for (int i = 1; i < MX; i++) {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i)).mod(MOD);
        }
        invFact[MX - 1] = qpow(fact[MX - 1], MOD.subtract(BigInteger.TWO));
        for (int i = MX - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1].multiply(BigInteger.valueOf(i + 1)).mod(MOD);
        }
    }

    static BigInteger comb(int n, int m) {
        if (m < 0 || m > n) return BigInteger.ZERO;
        return fact[n].multiply(invFact[m]).mod(MOD).multiply(invFact[n - m]).mod(MOD);
    }

    public int countGoodArrays(int n, int m, int k) {
        init();
        BigInteger res = comb(n - 1, k);
        res = res.multiply(BigInteger.valueOf(m)).mod(MOD);
        res = res.multiply(qpow(BigInteger.valueOf(m - 1), BigInteger.valueOf(n - k - 1))).mod(MOD);
        return res.intValue();
    }
}
