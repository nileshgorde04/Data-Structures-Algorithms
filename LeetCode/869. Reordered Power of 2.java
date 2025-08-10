/*
869. Reordered Power of 2
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

 

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
 

Constraints:

1 <= n <= 109
*/

//Solution

class Solution {
    private boolean ans = false;
    public void permute(String prefix, String remaining) {
    if (remaining.length() == 0) {
        int num = Integer.parseInt(prefix);
        if(!prefix.startsWith("0") && Integer.bitCount(num)==1) ans=true;
        return;
    }

    for (int i = 0; i < remaining.length(); i++) {
        char fixedChar = remaining.charAt(i);
        String rest = remaining.substring(0, i) + remaining.substring(i + 1);
        permute(prefix + fixedChar, rest);
    }
    }   
    public boolean reorderedPowerOf2(int n) {
        permute("",Integer.toString(n));
        return ans;
    }
}