/*
413. Arithmetic Slices
Solved
Medium
Topics
Companies
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
*/

//Solution

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int cnt=0;
        int curr=0;
        for(int i=2;i<nums.length;i++){
            int j=i-2;
            if(nums[i]-nums[i-1]==nums[i-1]-nums[j]){
                curr++;
                cnt+=curr;
            }
            else{
                curr=0;
            }
        }
        return cnt;
    }
}