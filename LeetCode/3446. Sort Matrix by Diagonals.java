/*
3446. Sort Matrix by Diagonals
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an n x n square matrix of integers grid. Return the matrix such that:

The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
The diagonals in the top-right triangle are sorted in non-decreasing order.
 

Example 1:

Input: grid = [[1,7,3],[9,8,2],[4,5,6]]

Output: [[8,2,3],[9,6,7],[4,5,1]]

Explanation:



The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:

[1, 8, 6] becomes [8, 6, 1].
[9, 5] and [4] remain unchanged.
The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:

[7, 2] becomes [2, 7].
[3] remains unchanged.
Example 2:

Input: grid = [[0,1],[1,2]]

Output: [[2,1],[1,0]]

Explanation:



The diagonals with a black arrow must be non-increasing, so [0, 2] is changed to [2, 0]. The other diagonals are already in the correct order.

Example 3:

Input: grid = [[1]]

Output: [[1]]

Explanation:

Diagonals with exactly one element are already in order, so no changes are needed.

 

Constraints:

grid.length == grid[i].length == n
1 <= n <= 10
-105 <= grid[i][j] <= 105
*/

//Solution

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        if(grid.length<2) return grid;
        int[][] ans = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                ans[i][j] = grid[i][j];
            }
        }
        for(int i=0;i<grid[0].length;i++) {
            List<Integer> list = new ArrayList<>();
            int row = 0, col=i;
            while(row<grid.length && col<grid[0].length) {
                list.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            row = 0; col=i;
            int index = 0;
            while(row<grid.length && col<grid[0].length) {
                ans[row][col] = list.get(index++);
                row++;
                col++;
            }
        }
        for(int i=0;i<grid.length;i++) {
            List<Integer> list = new ArrayList<>();
            int row = i, col=0;
            while(row<grid.length && col<grid[0].length) {
                list.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(list, Collections.reverseOrder());
            row = i; col=0;
            int index = 0;
            while(row<grid.length && col<grid[0].length) {
                ans[row][col] = list.get(index++);
                row++;
                col++;
            }
        }
        return ans;
    }
}
