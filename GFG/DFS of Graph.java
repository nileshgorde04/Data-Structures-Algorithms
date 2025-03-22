class Solution {
    public static void dfs(Integer node,boolean[] visit,ArrayList<ArrayList<Integer>> adj
                                                            , ArrayList<Integer> list){
         visit[node]=true;
         list.add(node);
         for(Integer it:adj.get(node)){
             if(!visit[it]){
                 dfs(it,visit,adj,list);
             }
         }
     }
     
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list=new ArrayList<>();
        boolean visit[]=new boolean[adj.size()+1];
        visit[0]=true;
        dfs(0,visit,adj,list);
     return list;
    }
}