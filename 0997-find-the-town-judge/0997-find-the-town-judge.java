class Solution {
    
    public int findJudge(int n, int[][] trust) {
        int []indegree = new int[n+1];
        int []outdegree = new int[n+1];
        for(int []arr : trust){
            int u = arr[0];
            int v = arr[1];
            // adj.get(u).add(v);
            indegree[v]++;
            outdegree[u]++;
            
        }
        
        for(int i=1;i<=n;i++){
            if(indegree[i]==n-1 && outdegree[i]==0) return i;
        }
        return -1;
    }
}