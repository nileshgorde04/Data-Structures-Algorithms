/*
316. Remove Duplicate Letters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
*/

//Solution

class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        boolean[] visited = new boolean[26]; // to ensure uniqueness

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            // Decrease frequency as the char is now being processed
            freq.put(c, freq.get(c) - 1);

            // Skip this char if it’s already added
            if (visited[c - 'a']) continue;

            // Remove characters from the end of ans if:
            // 1. They are greater than current char (we want lexicographically small)
            // 2. They will appear again later (freq > 0)
            while (ans.length() > 0 && c < ans.charAt(ans.length() - 1) &&
                   freq.get(ans.charAt(ans.length() - 1)) > 0) {
                char removed = ans.charAt(ans.length() - 1);
                ans.deleteCharAt(ans.length() - 1);
                visited[removed - 'a'] = false;
            }

            ans.append(c);
            visited[c - 'a'] = true;
        }

        return ans.toString();
    }
}


