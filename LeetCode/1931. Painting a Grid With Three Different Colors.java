/*
1931. Painting a Grid With Three Different Colors
Solved
Hard
Topics
Companies
Hint
You are given two integers m and n. Consider an m x n grid where each cell is initially white. You can paint each cell red, green, or blue. All cells must be painted.

Return the number of ways to color the grid with no two adjacent cells having the same color. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 1, n = 1
Output: 3
Explanation: The three possible colorings are shown in the image above.
Example 2:


Input: m = 1, n = 2
Output: 6
Explanation: The six possible colorings are shown in the image above.
Example 3:

Input: m = 5, n = 5
Output: 580986

Constraints:

1 <= m <= 5
1 <= n <= 1000
*/

//Solution

class Solution {
    static final int MOD = 1_000_000_007;
    List<String> comb = new ArrayList<>();
    Map<Integer, List<Integer>> G = new HashMap<>();
    Map<String, Integer> patternIndex = new HashMap<>();

    public void generate(String s, char prev, int m) {
        if (m == 0) {
            patternIndex.put(s, comb.size());
            comb.add(s);
            return;
        }
        for (char c : "RGB".toCharArray()) {
            if (c != prev) generate(s + c, c, m - 1);
        }
    }

    public int colorTheGrid(int m, int n) {
        generate("", '*', m);
        int combSize = comb.size();

        for (int i = 0; i < combSize; i++) {
            for (int j = 0; j < combSize; j++) {
                boolean compatible = true;
                for (int k = 0; k < m; k++) {
                    if (comb.get(i).charAt(k) == comb.get(j).charAt(k)) {
                        compatible = false;
                        break;
                    }
                }
                if (compatible) G.computeIfAbsent(i, x -> new ArrayList<>()).add(j);
            }
        }

        int[][] dp = new int[n][combSize];
        for (int i = 0; i < combSize; i++) dp[0][i] = 1;

        for (int col = 1; col < n; col++) {
            for (int cur = 0; cur < combSize; cur++) {
                for (int prev : G.get(cur)) {
                    dp[col][cur] = (dp[col][cur] + dp[col - 1][prev]) % MOD;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < combSize; i++) result = (result + dp[n - 1][i]) % MOD;

        return result;
    }
}


