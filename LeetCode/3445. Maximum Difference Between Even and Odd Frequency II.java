/*
3445. Maximum Difference Between Even and Odd Frequency II
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given a string s and an integer k. Your task is to find the maximum difference between the frequency of two characters, freq[a] - freq[b], in a substring subs of s, such that:

subs has a size of at least k.
Character a has an odd frequency in subs.
Character b has an even frequency in subs.
Return the maximum difference.

Note that subs can contain more than 2 distinct characters.

 

Example 1:

Input: s = "12233", k = 4

Output: -1

Explanation:

For the substring "12233", the frequency of '1' is 1 and the frequency of '3' is 2. The difference is 1 - 2 = -1.

Example 2:

Input: s = "1122211", k = 3

Output: 1

Explanation:

For the substring "11222", the frequency of '2' is 3 and the frequency of '1' is 2. The difference is 3 - 2 = 1.

Example 3:

Input: s = "110", k = 3

Output: -1

 

Constraints:

3 <= s.length <= 3 * 104
s consists only of digits '0' to '4'.
The input is generated that at least one substring has a character with an even frequency and a character with an odd frequency.
1 <= k <= s.length
*/

//Solution

class Solution 
{
    public int maxDifference(String s, int k) 
    {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        // Step 1: Try all pairs of digits a != b
        for (int a = 0; a <= 4; ++a) 
        {
            for (int b = 0; b <= 4; ++b) 
            {
                if (a == b)
                {
                    continue;
                } 

                // Step 2: Prefix sums of counts of a and b
                int[] s1 = new int[n + 1];
                int[] s2 = new int[n + 1];
                for (int i = 1; i <= n; ++i) 
                {
                    s1[i] = s1[i - 1] + (s.charAt(i - 1) - '0' == a ? 1 : 0);
                    s2[i] = s2[i - 1] + (s.charAt(i - 1) - '0' == b ? 1 : 0);
                }

                // Step 3: g[pa][pb] stores max (s2[j] - s1[j]) for each parity
                int[][] g = new int[2][2];
                for (int i = 0; i < 2; i++)
                {
                    Arrays.fill(g[i], Integer.MIN_VALUE);
                } 

                int j = 0;

                // Step 4: Scan from position k
                for (int i = k; i <= n; i++) 
                {
                    while (i - j >= k && s1[i] > s1[j] && s2[i] > s2[j]) 
                    {
                        int pa = s1[j] % 2;
                        int pb = s2[j] % 2;
                        g[pa][pb] = Math.max(g[pa][pb], s2[j] - s1[j]);
                        j++;
                    }

                    int pa = s1[i] % 2;
                    int pb = s2[i] % 2;
                    int best = g[1 - pa][pb];
                    if (best != Integer.MIN_VALUE) 
                    {
                        ans = Math.max(ans, (s1[i] - s2[i]) + best);
                    }
                }
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
