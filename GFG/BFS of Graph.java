// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] visit=new boolean[V];
        Queue<Integer> queue=new LinkedList<>();
        
        queue.add(0);
        visit[0]=true;
        
        while(!queue.isEmpty()){
            Integer node= queue.poll();
            bfs.add(node);
            
            for(Integer it: adj.get(node)){
                if(visit[it]==false){
                    visit[it]=true;
                    queue.add(it);
                } 
            }
        }
        return bfs;
    }
}