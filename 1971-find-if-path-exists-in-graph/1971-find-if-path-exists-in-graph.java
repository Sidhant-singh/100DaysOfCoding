class Solution {
        public boolean validPath(int n, int[][] edges, int start, int end) {
//        int l = edges.length;
//        if(n-l>=2) return false;
//        return true;
//        we should be converting edges to adjacency list
        if(start==end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean []vis = new boolean[n];
        vis[start] = true;
        //bfs(start,adj,vis,end);
        return dfs(start,adj,vis,end); 
    }
     private boolean dfs(int start, List<List<Integer>> adj, boolean[] vis,int end) {
        vis[start] = true;
         if(start==end) return true;
        for(int ele : adj.get(start)){
            if(!vis[ele]){
                if(dfs(ele,adj,vis,end)){
                    return true;
                }
            }
        }
         
         return false;
    }

    private void bfs(int start, List<List<Integer>> adj, boolean[] vis,int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int front = q.poll();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele] = true;
                    if(ele==end) return;
                }
            }
        }
    }

}