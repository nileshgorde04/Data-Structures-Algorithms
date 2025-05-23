/*
242. Valid Anagram
Solved
Easy
Topics
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/

//Solution


class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] s_count=new int[26];
        int[] t_count=new int[26];

        for(int i=0;i<s.length();i++){
            s_count[s.charAt(i)-'a']++;
            t_count[t.charAt(i)-'a']++;
        }
        for(int i=0;i<s_count.length;i++){
            if(s_count[i]!=t_count[i]) return false;
        }
        return true;
    }
}
