/*
1679. Max Number of K-Sum Pairs
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109
*/

//Solution

// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         boolean[] visited = new boolean[nums.length];
//         int ans = 0;
//         for(int i=0;i<nums.length-1;i++) {
//             if(visited[i]==true) continue;
//             for(int j=i+1;j<nums.length;j++) {
//                 if(visited[i]==true || visited[j]==true) continue;
//                 if(nums[i]+nums[j]==k){
//                     ans++;
//                     visited[i]=true;
//                     visited[j]=true;
//                 }
//             }
//         }
//         return ans;
//     }
// }

import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int complement = k - num;
            if (map.getOrDefault(complement, 0) > 0) {
                count++;
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}

