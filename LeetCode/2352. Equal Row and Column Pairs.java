/*
2352. Equal Row and Column Pairs
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105
*/

//Solution

class Solution {
    public int equalPairs(int[][] grid) {
        int cnt = 0;
        List<Integer> list  = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<grid.length;i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<grid[0].length;j++) {
                arr.add(grid[i][j]);
            }
            map.put(i, arr);
        }
        Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        for(int i=0;i<grid[0].length;i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<grid.length;j++) {
                arr.add(grid[j][i]);
            }
            map2.put(i, arr);
        }
        for(ArrayList<Integer> row : map.values()) {
            for(ArrayList<Integer> col : map2.values()) {
                if(row.equals(col)) cnt++;
            }
        }
        return cnt;
    }
} 

