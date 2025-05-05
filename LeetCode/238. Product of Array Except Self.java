/*
238. Product of Array Except Self
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/

//Solution

// int[] ans=new int[nums.length];
//         int mul=1;
//         for(int n:nums){
//             if(n==0) continue;
//             mul*=n;
//         }
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==0){
//                 ans[i]=mul;
//                 for(int j=0;j<nums.length;j++){
//                     if(nums[j]==0) continue;
//                     else
//                     ans[j]=0;
//                 }
//                 break;
//             }
//             else{
//                 ans[i]=mul/nums[i];
//             }
//         }
//         return ans;


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }
        return answer;
    }
}
