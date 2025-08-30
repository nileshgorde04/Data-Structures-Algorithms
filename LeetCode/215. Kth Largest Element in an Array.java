/*
215. Kth Largest Element in an Array
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*/

//Solution

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<nums.length;i++) {
            queue.add(nums[i]);
        }
        int cnt = 0;
        while(cnt!=k+1) {
            cnt++;
            if(cnt==k) return queue.poll();
            queue.poll();
        }
        return 0;
    }
}
