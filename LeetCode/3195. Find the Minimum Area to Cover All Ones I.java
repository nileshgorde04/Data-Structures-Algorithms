/*
3195. Find the Minimum Area to Cover All Ones I
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.

Return the minimum possible area of the rectangle.

 

Example 1:

Input: grid = [[0,1,0],[1,0,1]]

Output: 6

Explanation:



The smallest rectangle has a height of 2 and a width of 3, so it has an area of 2 * 3 = 6.

Example 2:

Input: grid = [[1,0],[0,0]]

Output: 1

Explanation:



The smallest rectangle has both height and width 1, so its area is 1 * 1 = 1.

 

Constraints:

1 <= grid.length, grid[i].length <= 1000
grid[i][j] is either 0 or 1.
The input is generated such that there is at least one 1 in grid.
*/

//Solution

class Solution {
    public int minimumArea(int[][] grid) {
        int minFirst = Integer.MAX_VALUE;
        int maxLast = Integer.MIN_VALUE;
        int minStart = Integer.MAX_VALUE;
        int maxStart = Integer.MIN_VALUE;
        boolean change = false;
        for(int i=0;i<grid.length;i++) {
            int min = -1;
            int max = -1;
            for(int j = 0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    if(min==-1) min = j;
                    max = j;
                    change = true;
                }
                
                if (min != -1) {
                minFirst = Math.min(minFirst, min);
                maxLast = Math.max(maxLast, max);
                minStart = Math.min(minStart, i);
                maxStart = Math.max(maxStart, i);
            }
            }

        }
        if(minFirst!= Integer.MAX_VALUE) {
            int rows = (maxStart-minStart)+1;
            int cols = (maxLast-minFirst)+1;
            return rows*cols;
        }
        return 0;
    }
}