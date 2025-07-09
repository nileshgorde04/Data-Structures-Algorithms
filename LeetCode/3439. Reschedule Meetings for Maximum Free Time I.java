/*
3439. Reschedule Meetings for Maximum Free Time I
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.

You are also given two integer arrays startTime and endTime, each of length n. These represent the start and end time of n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most k meetings by moving their start time while maintaining the same duration, to maximize the longest continuous period of free time during the event.

The relative order of all the meetings should stay the same and they should remain non-overlapping.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event.

 

Example 1:

Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:



Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

Example 2:

Input: eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]

Output: 6

Explanation:



Reschedule the meeting at [2, 4] to [1, 3], leaving no meetings during the time [3, 9].

Example 3:

Input: eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

Output: 0

Explanation:

There is no time during the event not occupied by meetings.

 

Constraints:

1 <= eventTime <= 109
n == startTime.length == endTime.length
2 <= n <= 105
1 <= k <= n
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
*/

//Solution

import java.util.*;

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];

        // Calculate the first and last gap separately
        gaps[0] = startTime[0];  // Free time before the first meeting
        gaps[n] = eventTime - endTime[n - 1];  // Free time after the last meeting

        // Compute gaps between meetings
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        // Compute prefix sum for efficient range sum calculation
        int[] pref = new int[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            pref[i] = pref[i - 1] + gaps[i - 1];
        }

        // Sliding window to find the maximum sum of k+1 consecutive gaps
        int ans = 0;
        for (int i = k + 1; i <= n + 1; i++) {
            ans = Math.max(ans, pref[i] - pref[i - (k + 1)]);
        }

        return ans;
    }
}