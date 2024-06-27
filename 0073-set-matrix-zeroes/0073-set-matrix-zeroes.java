class Solution {
    public void setZeroes(int[][] arr) {
        
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
//         boolean [] rows = new boolean[m];
//         boolean [] cols  = new boolean[n];
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(arr[i][j]==0){
//                     rows[i] = true;
//                     cols[j] = true;
//                 }
//             }
//         }
        
//         for(int i=0;i<m;i++){
//             if(rows[i] == true){
//                 for(int j=0;j<n;j++){
//                     arr[i][j] = 0;
//                 }
//             }
//         }
        
        
//         for(int j=0;j<n;j++){
//             if(cols[j] == true){
//                 for(int i=0;i<m;i++){
//                     arr[i][j] = 0;
//                 }
//             }
//         }
        
//         THIRD METHOD OPTIMIZED METHOD
        int m = arr.length;
        int n = arr[0].length;
        
        boolean zeroRow = false;
        boolean zeroCol = false;
        //check the 0th row
        for(int j=0;j<n;j++){
            if(arr[0][j] == 0){
                zeroRow = true;
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(arr[i][0] == 0){
                zeroCol = true;
                break;
            }
        }
        
        //setting the 0th row and column to zero for marking
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        
        //traverse in 0th row 
        for(int j=1;j<n;j++){
            if(arr[0][j] == 0){
                for(int i=1;i<m;i++){
                    arr[i][j] = 0;
                }
            }
        }
        
        //traverse in 0th col
        for(int i=1;i<m;i++){
            if(arr[i][0] == 0){
                for(int j=1;j<n;j++){
                    arr[i][j] = 0;
                }
            }
        }
        
        if(zeroRow == true){ // set the 0th row to zero
            for(int i=0;i<n;i++){
                arr[0][i] = 0;
            }
        }
        if(zeroCol == true){
            for(int i=0;i<m;i++){
                arr[i][0] = 0;
            }
        }
        }
    }