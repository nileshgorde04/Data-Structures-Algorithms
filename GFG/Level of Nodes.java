/*
Level of Nodes
Difficulty: MediumAccuracy: 50.95%Submissions: 61K+Points: 4Average Time: 15m
Given an integer x and an undirected acyclic graph with v nodes, labeled from 0 to v-1, and e edges, return the level of node labeled as x.

Level is the minimum number of edges you must travel from the node 0 to some target.

If there doesn't exists such a node that is labeled as x, return -1.

Examples :

Input: x = 4

Output: 2
Explanation:

We can clearly see that Node 4 lies at Level 2.
Input: x = 1
 
Output: 1
Explanation: Node 1 lies at level 1, immediate after Node 0.
Expected Time Complexity: O(v)
Expected Auxiliary Space: O(v)

Constraints:
2 ≤ v ≤ 104
1 ≤ e ≤ 104
0 ≤ adji, j < v
1 ≤ x < v

Note : Graph doesn't contain multiple edges and self loops.
*/

/*Complete the function below*/

class Solution {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        // code here
        Queue<Integer> queue = new LinkedList<>();
        int[] vis = new int[V];
        queue.add(0);
        vis[0] = 1;
        int level = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                
                if (node == X) return level;
                
                for (int neighbor : adj.get(node)) {
                    if (vis[neighbor]==0) {
                        vis[neighbor] = 1;
                        queue.add(neighbor);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}