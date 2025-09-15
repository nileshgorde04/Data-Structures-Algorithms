/*
994. Rotting Oranges
Solved
Medium
Topics
premium lock icon
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/

//Solution

class Pair {
    int row, col, time;
    public Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int cnt = 0;
        int[][] vis = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                if(grid[i][j]==2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else vis[i][j] = 0;
                if(grid[i][j] == 1) cnt++;
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int cntOne = 0, tm = 0;
        while(!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            tm = Math.max(tm, t);
            queue.poll();
            for(int i = 0;i<4;i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow<n && nrow >=0 && ncol<m && ncol>=0 && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1) {
                    queue.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    cntOne++;
                }
            }
        }
        if(cnt!=cntOne) return -1;
        return tm;
    }
}