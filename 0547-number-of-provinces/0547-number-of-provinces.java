class Solution {
        static int []parent;
    public int find(int a){
        if(parent[a]==a) return a;
        return find(parent[a]);
    }

    public void union(int a,int b){
        int leaderA = find(a);
        int leaderB = find(b);
        if(leaderA!=leaderB){
            parent[leaderB] = leaderA;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1]; // 1 to n nodes
//        every node is a parent of itself
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        parent[0] = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
//                edge is formed her from i+1 to j+1
//                union - helps in making it doing in the same groups
                if(i!=j && isConnected[i][j]==1) union(i+1,j+1);
            }
        }

        int count  = 0 ;
        for(int i=1;i<=n;i++){
            if(parent[i]==i) count++;
        }

        return count;
    }

}