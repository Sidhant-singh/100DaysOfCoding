class Solution {
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
//         First method
//         int [][] helper = new int[m][n];
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 helper[i][j] = arr[i][j];
//             }
//         }
        
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(helper[i][j] == 0){
// //                     setting ith row and column to zero
//                 for(int a=0;a<n;a++){
//                     arr[i][a] = 0;
//                 }
//                 for(int b=0;b<m;i++){
//                     arr[b][j] = 0;
//                 }
//                 }
//             }

//         Second method(optimized)
        boolean [] rows = new boolean[m];
        boolean [] cols  = new boolean[n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            if(rows[i] == true){
                for(int j=0;j<n;j++){
                    arr[i][j] = 0;
                }
            }
        }
        
        
        for(int j=0;j<n;j++){
            if(cols[j] == true){
                for(int i=0;i<m;i++){
                    arr[i][j] = 0;
                }
            }
        }
        }
    }