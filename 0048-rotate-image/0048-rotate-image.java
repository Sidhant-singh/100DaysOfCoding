class Solution {
    
    public void swap(int [][]matrix, int i, int j, int x, int y){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
    
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        
        // Transpose the matrix
        for(int i = 0; i < m; i++){
            for(int j = 0; j < i; j++){
                swap(matrix, i, j, j, i);
            }
        }
        
        // Reverse each row
        for(int i = 0; i < m; i++){
            int start = 0;
            int end = matrix[i].length - 1;
            
            while(start < end){
                swap(matrix, i, start, i, end);
                start++;
                end--;
            }
        }
    }
}
