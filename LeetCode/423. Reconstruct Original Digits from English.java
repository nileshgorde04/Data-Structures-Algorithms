/*
423. Reconstruct Original Digits from English
Solved
Medium
Topics
Companies
Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.

 

Example 1:

Input: s = "owoztneoer"
Output: "012"
Example 2:

Input: s = "fviefuro"
Output: "45"
 

Constraints:

1 <= s.length <= 105
s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
s is guaranteed to be valid.
*/

//Solution

import java.util.*;

class Solution {
    public String originalDigits(String s) {
        int[] letterCount=new int[26];
        for(char c:s.toCharArray()) letterCount[c-'a']++;

        int[] digitCount=new int[10];
        digitCount[0]=letterCount['z'-'a'];
        digitCount[2]=letterCount['w'-'a'];
        digitCount[4]=letterCount['u'-'a'];
        digitCount[6]=letterCount['x'-'a'];
        digitCount[8]=letterCount['g'-'a'];
        digitCount[3]=letterCount['h'-'a']-digitCount[8];
        digitCount[5]=letterCount['f'-'a']-digitCount[4];
        digitCount[7]=letterCount['s'-'a']-digitCount[6];
        digitCount[9]=letterCount['i'-'a']-digitCount[5]-digitCount[6]-digitCount[8];
        digitCount[1]=letterCount['o'-'a']-digitCount[0]-digitCount[2]-digitCount[4];

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=9;i++) {
            for(int j=0;j<digitCount[i];j++) sb.append(i);
        }
        return sb.toString();
    }
}
