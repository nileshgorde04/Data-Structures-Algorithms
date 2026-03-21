/*
410. Split Array Largest Sum
Solved
Hard
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
*/

//Solution

class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0, min = Integer.MIN_VALUE;
        for(int i : nums) {
            sum += i;
            if(i>min) min = i;
        }
        int max = 0;
        while(min<=sum) {
            int mid = (min+sum)/2;
            int cnt = 1, add = 0;
            for(int i=0;i<nums.length;i++) {
                if(add + nums[i] <= mid) {
                    add += nums[i];
                }
                else {
                    cnt++;
                    add = nums[i];
                }
            }
            if(cnt<=k) {
                max = mid;
                sum = mid - 1;
            }
            else min = mid + 1; 
        }
        return max;
    }
}