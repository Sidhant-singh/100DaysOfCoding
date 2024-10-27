class Solution {
        class Pair{
        int row ;
        int col;

        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) { // '1' is land
        int m = grid.length;
        int n = grid[0].length;
        boolean [][]vis = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    bfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] vis) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        q.add(new Pair(i, j));
        while (q.size()>0){
            Pair front = q.poll();
            int row = front.row;
            int col = front.col;
//            top -> row-1,col
            if(row>0){
                if(vis[row-1][col]==false && grid[row-1][col]=='1'){
                    q.add(new Pair(row-1,col));
                    vis[row-1][col] = true;
                }
            }

//            bottom -> row+1,col
            if(row+1<m) {
                if (vis[row + 1][col] == false && grid[row + 1][col] == '1') {
                    q.add(new Pair(row + 1, col));
                    vis[row + 1][col] = true;
                }
            }

//            left -> row,col-1
            if(col>0){
                if(vis[row][col-1]==false && grid[row][col-1]=='1'){
                    q.add(new Pair(row,col-1));
                    vis[row][col-1] = true;
                }
            }
//            right -> row,col+1
            if(col+1<n){
                if(vis[row][col+1]==false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    vis[row][col+1] = true;
                }
            }

        }
    }

}