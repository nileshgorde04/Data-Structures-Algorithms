/*
3341. Find Minimum Time to Reach Last Room I
Solved
Medium
Topics
Companies
Hint
There is a dungeon with n x m rooms arranged as a grid.

You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes exactly one second.

Return the minimum time to reach the room (n - 1, m - 1).

Two rooms are adjacent if they share a common wall, either horizontally or vertically.

 

Example 1:

Input: moveTime = [[0,4],[4,4]]

Output: 6

Explanation:

The minimum time required is 6 seconds.

At time t == 4, move from room (0, 0) to room (1, 0) in one second.
At time t == 5, move from room (1, 0) to room (1, 1) in one second.
Example 2:

Input: moveTime = [[0,0,0],[0,0,0]]

Output: 3

Explanation:

The minimum time required is 3 seconds.

At time t == 0, move from room (0, 0) to room (1, 0) in one second.
At time t == 1, move from room (1, 0) to room (1, 1) in one second.
At time t == 2, move from room (1, 1) to room (1, 2) in one second.
Example 3:

Input: moveTime = [[0,1],[1,2]]

Output: 3

 

Constraints:

2 <= n == moveTime.length <= 50
2 <= m == moveTime[i].length <= 50
0 <= moveTime[i][j] <= 109
*/

//Solution

class Solution {
   static public int minTimeToReach(int[][] moveTime) {
        int r = moveTime.length, c = moveTime[0].length;
        int[][] minimumTime = new int[r][c];
        for (int[] is : minimumTime) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.steps - b.steps);
        pq.add(new Pair(-1, 0, 0));
        minimumTime[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int i = top.i, j = top.j, nextStep = top.steps + 1;
            if (i + 1 < r) update(i + 1, j, pq, nextStep, moveTime, minimumTime);
            if (i - 1 >= 0) update(i - 1, j, pq, nextStep, moveTime, minimumTime);
            if (j - 1 >= 0) update(i, j - 1, pq, nextStep, moveTime, minimumTime);
            if (j + 1 < c)  update(i, j + 1, pq, nextStep, moveTime, minimumTime);
            if(minimumTime[r-1][c-1] != Integer.MAX_VALUE) return minimumTime[r-1][c-1] + 1;
        }
        return minimumTime[r-1][c-1] + 1;
    }

    static void update(int i, int j, PriorityQueue<Pair> pq, int nextStep, int[][] moveTime, int[][] minimumTime){
        if (nextStep < moveTime[i][j]) nextStep = moveTime[i][j];
        if (minimumTime[i][j] > nextStep) {
            pq.add(new Pair(nextStep, i, j));
            minimumTime[i][j] = nextStep;
        }
    }

}

class Pair {
    int steps = 0, i = -1, j = -1;

    public Pair(int steps, int i, int j) {
        this.steps = steps;
        this.i = i;
        this.j = j;
    }
}