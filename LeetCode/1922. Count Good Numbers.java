/*
1922. Count Good Numbers

A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303
 

Constraints:

1 <= n <= 1015


Solution 

Intuition
The problem is asking us to calculate the number of valid "good numbers" of length n, where:

Even indexed positions (0, 2, 4, ...) must have even digits (0, 2, 4, 6, 8).
Odd indexed positions (1, 3, 5, ...) must have prime digits (2, 3, 5, 7).
Given that n can be as large as (10^{15}), a brute-force approach will not work. We can instead focus on counting the valid choices for each position without generating every possible number.

Approach
We can break the problem down as follows:

For even indexed positions, there are 5 choices (0, 2, 4, 6, 8).
For odd indexed positions, there are 4 choices (2, 3, 5, 7).
Thus, the total number of valid "good numbers" of length n will be:

( 5^{\lceil n / 2 \rceil} \times 4^{\lfloor n / 2 \rfloor} ).
We will calculate the result using modular exponentiation to efficiently compute large powers, and return the result modulo (10^9 + 7).

Complexity
Time complexity: ( O(\log n) ) due to the modular exponentiation.
Space complexity: ( O(1) ) as we are using only a constant amount of space.
*/

//Code
class Solution {

    public static long modPow(long base, long exp, long MOD) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        final int MOD = 1000000007;
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        long evenPart = modPow(5, evenCount, MOD);
        long oddPart = modPow(4, oddCount, MOD);
        return (int) ((evenPart * oddPart) % MOD);
    }
}
