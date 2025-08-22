/*
2348. Number of Zero-Filled Subarrays
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, return the number of subarrays filled with 0.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,3,0,0,2,0,0,4]
Output: 6
Explanation: 
There are 4 occurrences of [0] as a subarray.
There are 2 occurrences of [0,0] as a subarray.
There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
Example 2:

Input: nums = [0,0,0,2,0,0]
Output: 9
Explanation:
There are 5 occurrences of [0] as a subarray.
There are 3 occurrences of [0,0] as a subarray.
There is 1 occurrence of [0,0,0] as a subarray.
There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
Example 3:

Input: nums = [2,10,2019]
Output: 0
Explanation: There is no subarray filled with 0. Therefore, we return 0.
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

//Solution

class Solution {
    public long findSubarrays(int num) {
        long sum = 0;
        while(num!=0) {
            sum += num;
            num-=1;
        }
        return sum;
    }
    public long zeroFilledSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i<nums.length) {
            int cnt = 0;
            while(i<nums.length && nums[i++]==0) cnt++;
            list.add(cnt);
        }
        if(list.size()==0) return 0;
        long ans = 0;
        for(int j = 0;j<list.size();j++) {
            ans += findSubarrays(list.get(j));
        }
        return ans;
    }
}