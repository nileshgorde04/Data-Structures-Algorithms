/*
605. Can Place Flowers
Solved
Easy
Topics
premium lock icon
Companies
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
*/

//Solution

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = n;
        int len = flowerbed.length;
        if(len==1) {
            if (flowerbed[0] == 0) cnt--;
            return cnt <= 0;
        }
            if(flowerbed[0]==0 && flowerbed[1]==0) {
                cnt--;
                flowerbed[0] = 1;
            } 
            if(flowerbed[len-2]==0 && flowerbed[len-1]==0) {
                cnt--;
                flowerbed[len-1] = 1;
            }
        for(int i=1;i<len-1;i++) {
            if(flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0) {
                cnt--;
                flowerbed[i]=1;
            }
            if(cnt<=0) return true;
        }
        return cnt <= 0;
    }
} 
