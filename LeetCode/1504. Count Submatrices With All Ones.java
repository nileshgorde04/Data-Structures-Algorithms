/*
1504. Count Submatrices With All Ones
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an m x n binary matrix mat, return the number of submatrices that have all ones.

 

Example 1:


Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
Output: 13
Explanation: 
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2. 
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
Example 2:


Input: mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
Output: 24
Explanation: 
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3. 
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2. 
There are 2 rectangles of side 3x1. 
There is 1 rectangle of side 3x2. 
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
 

Constraints:

1 <= m, n <= 150
mat[i][j] is either 0 or 1.
 

class Solution {
    public int numSubmat(int[][] mat) {
        
	int M = mat.length, N = mat[0].length;

	int res = 0;

	int[] h = new int[N];
	for (int i = 0; i < M; ++i) {
		for (int j = 0; j < N; ++j) {
			h[j] = (mat[i][j] == 0 ? 0 : h[j] + 1);
		}
		res += helper(h);
	}

	return res;
}

private int helper(int[] A) {

	int[] sum = new int[A.length];
	Stack<Integer> stack = new Stack<>();

	for (int i = 0; i < A.length; ++i) {

		while (!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();

		if (!stack.isEmpty()) {
			int preIndex = stack.peek();
			sum[i] = sum[preIndex];
			sum[i] += A[i] * (i - preIndex);
		} else {
			sum[i] = A[i] * (i + 1);
		}

		stack.push(i);
	}

	int res = 0;
	for (int s : sum) res += s;

	return res;
}
}
