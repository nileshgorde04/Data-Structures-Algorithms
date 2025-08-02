/*
54. Spiral Matrix
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

//Solution

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStarts = 0, colStarts = 0, colEnds = matrix[0].length-1,rowEnds = matrix.length-1;
        while(rowStarts<=rowEnds && colStarts<=colEnds) {
                for(int j = colStarts;j<=colEnds;j++) {
                    list.add(matrix[rowStarts][j]);
                }
                rowStarts++;
                for(int j = rowStarts; j<=rowEnds;j++) {
                    list.add(matrix[j][colEnds]);
                }
                colEnds--;
                if(rowStarts<=rowEnds) {
                    for(int j = colEnds; j>=colStarts;j--) {
                        list.add(matrix[rowEnds][j]);
                    }
                    rowEnds--;
                }   
                if(colStarts<=colEnds) {
                    for(int j = rowEnds; j>=rowStarts;j--) {
                        list.add(matrix[j][colStarts]);
                    }
                    colStarts++;
                } 
        }
        return list;
    }
}