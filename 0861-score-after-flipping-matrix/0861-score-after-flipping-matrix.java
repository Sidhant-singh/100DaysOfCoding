class Solution {
    public int matrixScore(int[][] arr) {
        int m = arr.length,n = arr[0].length;
        
//         changing the starting of all rows to one
        
        for(int i=0;i<m;i++){
            if(arr[i][0] == 0){
                for(int j=0;j<n;j++){
                    if(arr[i][j] == 0) arr[i][j] = 1;
                    else arr[i][j] = 0;
                }
            }
        }
//         flipping the rows where nzeros > nones
        for(int j = 1;j<n;j++){
            int nzeros = 0,nones = 0;
            for(int i=0;i<m;i++){
                if(arr[i][j]== 0) nzeros++;
                else nones++;
            }
            
            if(nzeros>nones){
                for(int i=0;i<m;i++){
                    if(arr[i][j] == 0) arr[i][j] = 1;
                    else arr[i][j] = 0;
                }
            }
        }
        
//         calculating the decimal part 
        int score = 0;
        int factor = 1;
        for(int j=n-1;j>=0;j--){
            for(int i=0;i<m;i++){
                score += (arr[i][j])*factor;
            }
            factor *= 2;
        }
        
        return score;
    }
}