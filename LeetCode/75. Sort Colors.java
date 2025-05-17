/*
75. Sort Colors
Solved
Medium
Topics
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/

//Solution

class Solution {
    public void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int PI=partitionIndex(nums,low,high);
        quickSort(nums, low, PI-1);
        quickSort(nums, PI+1, high);
    }
    public int partitionIndex(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i=low+1;
        int j=high;
        while(i<=j) {
            while(i<=high && nums[i]<=pivot) i++;
            while(j>=low && nums[j]>pivot) j--;
            if(i<j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
    return j;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
}
