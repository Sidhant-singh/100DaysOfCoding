class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean []vis = new boolean[n];
        vis[0] = true;
        bfs(0,adj,vis);
        for(boolean ele : vis){
            if(ele==false) return false;
        }
        return true;
    }

    private void bfs(int start, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(q.size()>0){
            int front = q.poll();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
}