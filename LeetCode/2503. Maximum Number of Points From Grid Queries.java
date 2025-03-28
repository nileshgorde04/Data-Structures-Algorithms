/* 2503. Maximum Number of Points From Grid Queries

You are given an m x n integer matrix grid and an array queries of size k.

Find an array answer of size k such that for each integer queries[i] you start in the top left cell of the matrix and repeat the following process:

If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
Otherwise, you do not get any points, and you end this process.
After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.

Return the resulting array answer.

 

Example 1:


Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
Output: [5,8,1]
Explanation: The diagrams above show which cells we visit to get points for each query.
Example 2:


Input: grid = [[5,2,1],[1,1,2]], queries = [3]
Output: [0]
Explanation: We can not get any points because the value of the top left cell is already greater than or equal to 3.
 

Constraints:

m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 105
k == queries.length
1 <= k <= 104
1 <= grid[i][j], queries[i] <= 106
*/

//Solution :
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length, qLen = queries.length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Store original indices and sort queries
        int[][] qIndex = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            qIndex[i] = new int[]{queries[i], i};
        }
        Arrays.sort(qIndex, Comparator.comparingInt(a -> a[0]));
        
        // Min-heap (PriorityQueue) to store (value, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        
        int[] result = new int[qLen];
        int count = 0;
        
        for (int[] q : qIndex) {
            int query = q[0], index = q[1];

            // Process the heap while top element is less than the query value
            while (!pq.isEmpty() && pq.peek()[0] < query) {
                int[] cell = pq.poll();
                int r = cell[1], c = cell[2];
                count++;

                // Explore neighbors
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            result[index] = count;
        }
        
        return result;
    }
}