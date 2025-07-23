/*
1717. Maximum Score From Removing Substrings
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
 

Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.
*/

//Solution

class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return solve(s, 'a', 'b', x, 'b', 'a', y);
        } else {
            return solve(s, 'b', 'a', y, 'a', 'b', x);
        }
    }

    private int solve(String s, char first1, char second1, int score1,
                             char first2, char second2, int score2) {
        int points = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 2) == first1 && sb.charAt(len - 1) == second1) {
                sb.delete(sb.length() - 2, sb.length());
                points += score1;
            }
        }

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            temp.append(sb.charAt(i));
            int len = temp.length();
            if (len >= 2 && temp.charAt(len - 2) == first2 && temp.charAt(len - 1) == second2) {
                temp.delete(temp.length() - 2, temp.length());
                points += score2;
            }
        }

        return points;
    }
}
