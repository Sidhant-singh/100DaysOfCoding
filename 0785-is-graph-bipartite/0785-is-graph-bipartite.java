class Solution {
        static int []parent;
    static int []size;
    static boolean[]parity;
    public int leader(int u){
        if(parent[u]==u) return u;
        return parent[u] = leader(parent[u]);
    }
    public void union(int u,int v){
        int a = leader(u);
        int b = leader(v);
        if(a!=b){
            if(size[a]>size[b]){
                parent[b] = a;
                size[a] += size[b];
//                reverse the colors of the nodes
                parity[v] = !parity[u];
            }
            else{
                parent[a] = b;
                size[b] += size[a];
                parity[u] = !parity[v];
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        parent = new int[n];
        size = new int[n];
        parity = new boolean[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
            parity[i] = false;
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                int u = i;
                int v = graph[i][j];
                if(v>u){
                    if(leader(u)==leader(v)) { //cycle detected
                        if(parity[u]==parity[v]) return false;
                    }
                    else union(u,v);
                }
            }
        }
        return true;
    }

}