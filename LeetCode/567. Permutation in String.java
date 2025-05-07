/*
567. Permutation in String
Solved
Medium
Topics
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/

//Solution

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] s1_count=new int[26];
        int[] s2_count=new int[26];
        for(int i=0;i<s1.length();i++){
            s1_count[s1.charAt(i)-'a']++;
            s2_count[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length()-s1.length();i++){
            if(matches(s1_count,s2_count)) return true;

            s2_count[s2.charAt(i)-'a']--;

            s2_count[s2.charAt(i+s1.length())-'a']++;
        }
        return matches(s1_count,s2_count);
    }
    public boolean matches(int[] arr, int[] arr1){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr1[i]) return false;
        }
        return true;
    }
}

