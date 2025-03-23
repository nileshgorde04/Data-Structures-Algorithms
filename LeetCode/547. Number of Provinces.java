/*547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.*/

//Solution :

class Solution {
    public static void bfs(int start, boolean[] visit,int[][] isConnected){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visit[start]=true;
        while(!queue.isEmpty()){
            Integer temp=queue.poll();
            for(int i=0;i<visit.length;i++){
                if(isConnected[temp][i]==1 && !visit[i]){
                    queue.add(i);
                    visit[i]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int cnt=0;
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                cnt++;
                bfs(i,visit, isConnected);
            }
        }
        return cnt;
    }
}