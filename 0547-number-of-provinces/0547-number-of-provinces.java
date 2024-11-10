class Solution {
       static int []parent;
    static int []size;
    public int find(int a){
        if(parent[a]==a) return a;
//        PATH COMPRESSION
//        SECOND OPTIMIZATION -> TO MAKE IT A TWO LVL TREE so that it heights can be reduced nd make it a balanced tree
//        so while we are finding the leader of any node so during back calls we will
//        perform backtracking as it helps to only one parent of all the nodes present in that groups.
        int leader = find(parent[a]);
        parent[a] = leader;
        return leader;
    }

    public void union(int a,int b) {
        a = find(a);
        b = find(b);
//        OPTIMIZATION DONE -> Earlier we are randomly making parent to one node to another but now we are
//        we are comparing the sizes of both the nodes and then whose size is greater than we make it
//        as a parent to other node.
        if (a != b) {
            if (size[a] > size[b]) { //a should be a parent of b
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1]; // 1 to n nodes
        size = new int[n+1];
//        every node is a parent of itself
        for(int i=1;i<=n;i++){
            parent[i] = i;
//            every node at the starting has a size 1 is they are individually scattered
            size[i] = 1;
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