/* 
2818. Apply Operations to Maximize Score

Hard

You are given an array nums of n positive integers and an integer k.

Initially, you start with a score of 1. You have to maximize your score by applying the following operation at most k times:

Choose any non-empty subarray nums[l, ..., r] that you haven't chosen previously.
Choose an element x of nums[l, ..., r] with the highest prime score. If multiple such elements exist, choose the one with the smallest index.
Multiply your score by x.
Here, nums[l, ..., r] denotes the subarray of nums starting at index l and ending at the index r, both ends being inclusive.

The prime score of an integer x is equal to the number of distinct prime factors of x. For example, the prime score of 300 is 3 since 300 = 2 * 2 * 3 * 5 * 5.

Return the maximum possible score after applying at most k operations.

Since the answer may be large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [8,3,9,3,8], k = 2
Output: 81
Explanation: To get a score of 81, we can apply the following operations:
- Choose subarray nums[2, ..., 2]. nums[2] is the only element in this subarray. Hence, we multiply the score by nums[2]. The score becomes 1 * 9 = 9.
- Choose subarray nums[2, ..., 3]. Both nums[2] and nums[3] have a prime score of 1, but nums[2] has the smaller index. Hence, we multiply the score by nums[2]. The score becomes 9 * 9 = 81.
It can be proven that 81 is the highest score one can obtain.
Example 2:

Input: nums = [19,12,14,6,10,18], k = 3
Output: 4788
Explanation: To get a score of 4788, we can apply the following operations: 
- Choose subarray nums[0, ..., 0]. nums[0] is the only element in this subarray. Hence, we multiply the score by nums[0]. The score becomes 1 * 19 = 19.
- Choose subarray nums[5, ..., 5]. nums[5] is the only element in this subarray. Hence, we multiply the score by nums[5]. The score becomes 19 * 18 = 342.
- Choose subarray nums[2, ..., 3]. Both nums[2] and nums[3] have a prime score of 2, but nums[2] has the smaller index. Hence, we multipy the score by nums[2]. The score becomes 342 * 14 = 4788.
It can be proven that 4788 is the highest score one can obtain.
 

Constraints:

1 <= nums.length == n <= 105
1 <= nums[i] <= 105
1 <= k <= min(n * (n + 1) / 2, 109)
*/

//Solved :
class Solution {
    public static final int MOD = (int)1e9+7;
    
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size(), max = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = nums.get(i);
        for(int num : arr) max = Math.max(max, num);

        int[] primeScores = getPrimeScores(arr, max);
        int[] multiplierCnt = new int[max+1]; 
        int[] greaterThanLeft = new int[n], greaterThanRight = new int[n]; 
        greaterThanLeft[0] = -1;
        greaterThanRight[n-1] = n;

        for(int i = 1; i < n; i++) {
            int left = i-1;
            while(left >= 0 && primeScores[arr[i]] > primeScores[arr[left]]) left = greaterThanLeft[left];
            greaterThanLeft[i] = left;

            int right = n-i;
            while(right < n && primeScores[arr[n-i-1]] >= primeScores[arr[right]]) right = greaterThanRight[right];
            greaterThanRight[n-i-1] = right;
        }

        for(int i = 0; i < n; i++) {
            int sz = greaterThanRight[i]-greaterThanLeft[i]-1, leftSz = i-greaterThanLeft[i]-1, rightSz = greaterThanRight[i]-i-1;
            long subarrays = (sz*(sz+1L))/2 - (leftSz*(leftSz+1L))/2 - (rightSz*(rightSz+1L))/2;
            multiplierCnt[arr[i]] = (int)Math.min(k, multiplierCnt[arr[i]] + subarrays);
        }

        long res = 1;
        for(int mult = max; mult > 0; mult--) {
            if(multiplierCnt[mult] == 0) continue;
            if(multiplierCnt[mult] >= k) {
                res = (res * modExp(mult, k)) % MOD;
                break;
            } else {
                res = (res * modExp(mult, multiplierCnt[mult])) % MOD;
                k -= multiplierCnt[mult];
            }
        }
        return (int)res;
    }

    private static int[] getPrimeScores(int[] nums, int max) {
        int[] spf = sieveSmallestPFactors(max), primeScores = new int[max+1];
        for(int num : nums) {
            if(primeScores[num] != 0) continue;
            int x = num;
            while(x > 1) {
                primeScores[num]++;
                int p = spf[x];
                while(spf[x] == p) x /= p;
            }
        }
        return primeScores;
    }

    private static int[] sieveSmallestPFactors(int lim) {
        int[] spf = new int[lim+1];
        boolean stopPostItr = false;
        for(int i = 3; i <= lim; i += 2) {
            spf[i-1] = 2;
            if(spf[i] != 0) continue;
            spf[i] = i;
            if(stopPostItr) continue;
            stopPostItr = i*i > lim;
            for(int j = i*i; j <= lim; j += 2*i) {
                if(spf[j] == 0) spf[j] = i;
            }
        }
        if(lim % 2 == 0) spf[lim] = 2;
        return spf;
    }

    private static long modExp(int base, int exp) {
        long multiplier = base, res = 1;
        while(exp > 0) {
            if((exp & 1) == 1) res = (res * multiplier) % MOD;
            multiplier = (multiplier * multiplier) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
