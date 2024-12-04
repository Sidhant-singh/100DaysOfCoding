class Solution {
    public int paths(int [][]grid,int sr,int sc,int [][]dp){
        int m = grid.length;
        int n = grid[0].length;
        if(sr>=m || sc>=n || grid[sr][sc]==1) return 0;
        if(sr==m-1 && sc==n-1) return 1;
        
        if(dp[sr][sc]!=-1) return dp[sr][sc];
        
        int right = paths(grid,sr,sc+1,dp);
        int down = paths(grid,sr+1,sc,dp);
        
        return dp[sr][sc] = right+down;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return paths(grid,0,0,dp);
    }
}