/*
2099. Find Subsequence of Length K With the Largest Sum
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
 

Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length
*/

//Solution

import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // index
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        int[][] topK = Arrays.copyOfRange(arr, 0, k);

        Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }

        return result;
    }
}
