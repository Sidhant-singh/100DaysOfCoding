class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int startColor = image[sr][sc];
        
        if(startColor == color) return image;
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        
        int []dx = {1,-1,0,0};
        int []dy = {0,0,1,-1};
        while(q.size()>0){
            int []point = q.poll();
            for(int i=0;i<4;i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                
                if(nx>=0 && ny>=0 && nx<m && ny<n && image[nx][ny]==startColor){
                    image[nx][ny] = color;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        
        return image;
    }   
}