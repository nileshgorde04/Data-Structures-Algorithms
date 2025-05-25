/*
2131. Longest Palindrome by Concatenating Two Letter Words
Solved
Medium
Topics
Companies
Hint
You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.

 

Example 1:

Input: words = ["lc","cl","gg"]
Output: 6
Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.
Example 2:

Input: words = ["ab","ty","yt","lc","cl","ab"]
Output: 8
Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.
Example 3:

Input: words = ["cc","ll","xx"]
Output: 2
Explanation: One longest palindrome is "cc", of length 2.
Note that "ll" is another longest palindrome that can be created, and so is "xx".
 

Constraints:

1 <= words.length <= 105
words[i].length == 2
words[i] consists of lowercase English letters.
*/

//Solution

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        boolean hasCenter = false;

        for (String s : words) {
            String rev = new StringBuilder(s).reverse().toString();
            if (map.containsKey(rev) && map.get(rev) > 0) {
                cnt += 4;
                map.put(rev, map.get(rev) - 1);
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        for (String s : map.keySet()) {
            if (s.charAt(0) == s.charAt(1) && map.get(s) > 0) {
                hasCenter = true;
                break;
            }
        }

        if (hasCenter) cnt += 2;
        return cnt;
    }
}
