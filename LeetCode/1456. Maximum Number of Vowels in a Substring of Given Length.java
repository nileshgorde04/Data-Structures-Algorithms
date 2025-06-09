/*
1456. Maximum Number of Vowels in a Substring of Given Length
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.


Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
*/

//Solution

// class Solution {
//     public int maxVowels(String s, int k) {
//         int max = 0;
//         for(int i=0;i<=s.length()-k;i++) {
//             String sub = s.substring(i,i+k);
//             int cnt = 0;
//             for(int j=0;j<sub.length();j++) {
//                 if("AEIOUaeiou".indexOf(sub.charAt(j))!=-1) cnt++;
//             }
//             max = Integer.max(cnt, max);
//         }
//         return max;
//     }
// }

class Solution {
    public int maxVowels(String s, int k) {
        int max = 0, count = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) count++;
            if (i >= k && vowels.contains(s.charAt(i - k))) count--;
            max = Math.max(max, count);
        }
        return max;
    }
}
