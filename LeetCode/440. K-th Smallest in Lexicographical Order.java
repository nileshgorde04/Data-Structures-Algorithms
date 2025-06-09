// Leetcode Problem : 440. K-th Smallest in Lexicographical Order
//link to problem : https://leetcode.com/problems/k-th-smallest-in-lexicographical-order?envType=daily-question&envId=2025-06-09
/* 

Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

 

Example 1:

Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
Example 2:

Input: n = 1, k = 1
Output: 1
 

Constraints:

1 <= k <= n <= 109
*/
//Solution for 440. K-th Smallest in Lexicographical Order
class Solution {
    public int findKthNumber(int n, int k) {
        int prefix=1;
        for(int count=1;count<k;){
            int currCount=getCountWithPrefix(prefix,prefix+1,n);
            if(currCount+count<=k){
                count+=currCount;
                prefix++;
            }else{
                prefix*=10;
                count++;
            }
        }
        return prefix;
    }
    private int getCountWithPrefix(long startPrefix,long endPrefix,int max){
        int count=0;
        while(startPrefix<=max){
            count+=Math.min(max+1,endPrefix)-startPrefix;
            startPrefix*=10;
            endPrefix*=10;
        }
        return count;
    }
}
