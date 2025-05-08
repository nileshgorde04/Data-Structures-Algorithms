/*
3342. Find Minimum Time to Reach Last Room II
Solved
Medium
Topics
Companies
Hint
There is a dungeon with n x m rooms arranged as a grid.

You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.

Return the minimum time to reach the room (n - 1, m - 1).

Two rooms are adjacent if they share a common wall, either horizontally or vertically.

 

Example 1:

Input: moveTime = [[0,4],[4,4]]

Output: 7

Explanation:

The minimum time required is 7 seconds.

At time t == 4, move from room (0, 0) to room (1, 0) in one second.
At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.
Example 2:

Input: moveTime = [[0,0,0,0],[0,0,0,0]]

Output: 6

Explanation:

The minimum time required is 6 seconds.

At time t == 0, move from room (0, 0) to room (1, 0) in one second.
At time t == 1, move from room (1, 0) to room (1, 1) in two seconds.
At time t == 3, move from room (1, 1) to room (1, 2) in one second.
At time t == 4, move from room (1, 2) to room (1, 3) in two seconds.
Example 3:

Input: moveTime = [[0,1],[1,2]]

Output: 4

 

Constraints:

2 <= n == moveTime.length <= 750
2 <= m == moveTime[i].length <= 750
0 <= moveTime[i][j] <= 109

*/

//Solution


class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // Store the input moveTime in a variable named roomMoveTime
        int[][] roomMoveTime = moveTime;  
        int totalRows = roomMoveTime.length;
        int totalCols = roomMoveTime[0].length;

        // Priority queue to store (current_time, row, col, step_cost)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.offer(new int[]{0, 0, 0, 1});  // Start at (0, 0) with time 0 and step cost 1
        
        int[][] minimumArrivalTime = new int[totalRows][totalCols];
        for (int[] row : minimumArrivalTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minimumArrivalTime[0][0] = 0;

        // Directions for adjacent rooms (down, up, right, left)
        int[][] adjacentDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!priorityQueue.isEmpty()) {
            int[] currentState = priorityQueue.poll();
            int currentTime = currentState[0], currentRow = currentState[1], currentCol = currentState[2], currentStepCost = currentState[3];

            // If we reached the target room (totalRows - 1, totalCols - 1)
            if (currentRow == totalRows - 1 && currentCol == totalCols - 1) {
                return currentTime;
            }

            // Explore adjacent rooms
            for (int[] direction : adjacentDirections) {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                if (nextRow >= 0 && nextRow < totalRows && nextCol >= 0 && nextCol < totalCols) {
                    int waitTime = Math.max(roomMoveTime[nextRow][nextCol] - currentTime, 0);
                    int newArrivalTime = currentTime + currentStepCost + waitTime;

                    // Only push to the queue if we found a better arrival time
                    if (newArrivalTime < minimumArrivalTime[nextRow][nextCol]) {
                        minimumArrivalTime[nextRow][nextCol] = newArrivalTime;
                        int nextStepCost = (currentStepCost == 2) ? 1 : 2;
                        priorityQueue.offer(new int[]{newArrivalTime, nextRow, nextCol, nextStepCost});
                    }
                }
            }
        }

        return -1; // Return -1 if the target room is unreachable
    }
}