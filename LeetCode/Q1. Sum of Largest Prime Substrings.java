/*
Q1. Sum of Largest Prime Substrings
Solved
Medium
4 pt.
Given a string s, find the sum of the 3 largest unique prime numbers that can be formed using any of its substrings.

Return the sum of the three largest unique prime numbers that can be formed. If fewer than three exist, return the sum of all available primes. If no prime numbers can be formed, return 0.

A prime number is a natural number greater than 1 with only two factors, 1 and itself.

A substring is a contiguous sequence of characters within a string.

Note: Each prime number should be counted only once, even if it appears in multiple substrings. Additionally, when converting a substring to an integer, any leading zeros are ignored.

 

Example 1:

Input: s = "12234"

Output: 1469

Explanation:

The unique prime numbers formed from the substrings of "12234" are 2, 3, 23, 223, and 1223.
The 3 largest primes are 1223, 223, and 23. Their sum is 1469.
Example 2:

Input: s = "111"

Output: 11

Explanation:

The unique prime number formed from the substrings of "111" is 11.
Since there is only one prime number, the sum is 11.
 

Constraints:

1 <= s.length <= 10
s consists of only digits.
*/

//Solution

import java.util.*;

class Solution {
    public long findNum(int i,int j,String s) {
        return Long.parseLong(s.substring(i,j));
    }

    public boolean isPrime(long num) {
        if (num<2) return false;
        for (long i=2;i*i<=num;i++) {
            if (num%i==0) return false;
        }
        return true;
    }

    public long sumOfLargestPrimes(String s) {
        Set<Long> uniquePrimes=new HashSet<>();
        for (int i=0;i<s.length();i++) {
            for (int j=i+1;j<=s.length();j++) {
                long num=findNum(i,j,s);
                if (isPrime(num)) uniquePrimes.add(num);
            }
        }

        List<Long> primeList=new ArrayList<>(uniquePrimes);
        Collections.sort(primeList,Collections.reverseOrder());

        long sum=0;
        for (int i=0;i<Math.min(3,primeList.size());i++) {
            sum+=primeList.get(i);
        }

        return sum;
    }
}
