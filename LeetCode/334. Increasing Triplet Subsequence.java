/*
334. Increasing Triplet Subsequence
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
*/

//Solution

// public boolean increasingTriplet(int[] nums) {
//         if(nums.length<3) return false;
//         for(int i =0;i<nums.length-2;i++) {
//             for(int j = i+1;j<nums.length-1;j++) {
//                 if(nums[i]<nums[j]){
//                     for(int k=j+1;k<nums.length;k++) {
//                         if(nums[j]<nums[k]) return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
class Solution {
    public boolean increasingTriplet(int[] nums) {
       int max1 = Integer.MAX_VALUE;
       int max2 = Integer.MAX_VALUE;
       for(int n : nums) {
           if(n <= max1) max1 = n;
           else if(n <= max2) max2 = n;
           else return true;
       }
       return false;
    }
}