//2685. Count the Number of Complete Components

/* You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices. */

//Solution :

class Solution {
    Set<Integer> vis = new HashSet<>();
    Map<Integer, Set<Integer>> nodes;
    public int countCompleteComponents(int n, int[][] edges) {
        //build graph to store all neighbors of each node, by loop the edge.
        nodes = buidGraph(edges);
        //Do BFS and check for each islands, res++ if complete.
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (vis.contains(i)) continue;
            if (bfs(i)) result++;
        }
        return result;
    }

    private Map<Integer, Set<Integer>> buidGraph(int[][] edges) {
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        for (int[] e : edges) {
            nodes.putIfAbsent(e[0], new HashSet<>());
            nodes.putIfAbsent(e[1], new HashSet<>());
            nodes.get(e[0]).add(e[1]);
            nodes.get(e[1]).add(e[0]);
        }
        return nodes;
    }

    private boolean bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis.add(i);
        int cntOfNeighs = nodes.getOrDefault(i, new HashSet<>()).size(), numOfNodes = 0;
        boolean result = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            numOfNodes++;
            if (nodes.getOrDefault(curr, new HashSet<>()).size() != cntOfNeighs) result = false;
            for (int neig : nodes.getOrDefault(curr, new HashSet<>())) {
                if (vis.contains(neig)) continue;
                vis.add(neig);
                q.offer(neig);
            }
        }
        return result && cntOfNeighs == numOfNodes - 1;
    }
} 

