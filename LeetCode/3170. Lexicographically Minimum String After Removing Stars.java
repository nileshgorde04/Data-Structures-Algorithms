//Leetcode Problem Number : 3170. Lexicographically Minimum String After Removing Stars
/*
You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.

While there is a '*', do the following operation:

Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, you can delete any of them.
Return the lexicographically smallest resulting string after removing all '*' characters.

 

Example 1:

Input: s = "aaba*"

Output: "aab"

Explanation:

We should delete one of the 'a' characters with '*'. If we choose s[3], s becomes the lexicographically smallest.

Example 2:

Input: s = "abc"

Output: "abc"

Explanation:

There is no '*' in the string.

 

Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters and '*'.
The input is generated such that it is possible to delete all '*' characters.
*/

//Solution 
class Solution {
  public String clearStars(String s) {
    StringBuilder sb = new StringBuilder(s);
    List<Integer>[] buckets = new List[26];

    for (int i = 0; i < 26; ++i)
      buckets[i] = new ArrayList<>();

    for (int i = 0; i < s.length(); ++i)
      if (s.charAt(i) == '*') {
        sb.setCharAt(i, ' ');
        int j = 0;
        while (buckets[j].isEmpty())
          ++j;
        sb.setCharAt(buckets[j].remove(buckets[j].size() - 1), ' ');
      } else {
        buckets[s.charAt(i) - 'a'].add(i);
      }

    return sb.toString().replaceAll(" ", "");
  }
}
