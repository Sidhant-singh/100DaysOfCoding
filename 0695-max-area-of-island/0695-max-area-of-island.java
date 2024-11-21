class Solution {
    
        
    public int dfs(int i,int j,boolean[][]vis,int [][]grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 || vis[i][j]){
            return 0;
        }
        
        vis[i][j] = true;
        int count = 1;
        count += dfs(i,j-1,vis,grid);
        count += dfs(i-1,j,vis,grid);
        count += dfs(i,j+1,vis,grid);
        count += dfs(i+1,j,vis,grid);
        
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        
        boolean [][]vis = new boolean[m][n];
//         largest possible area of island is 0
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int count = dfs(i,j,vis,grid);
                    max = Math.max(max,count);
                }
            }
        }
        if(max == Integer.MAX_VALUE) return 0;
        return max;
    }
}