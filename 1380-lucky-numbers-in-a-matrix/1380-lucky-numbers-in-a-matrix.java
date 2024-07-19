import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Step 1: Find the minimum element in each row
        for (int i = 0; i < m; i++) {
            int minRowValue = matrix[i][0];
            int minRowIndex = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minRowValue) {
                    minRowValue = matrix[i][j];
                    minRowIndex = j;
                }
            }
            
            // Step 2: Check if this min value is also the max in its column
            boolean isMaxInColumn = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][minRowIndex] > minRowValue) {
                    isMaxInColumn = false;
                    break;
                }
            }
            
            if (isMaxInColumn) {
                luckyNumbers.add(minRowValue);
            }
        }
        
        return luckyNumbers;
    }
}
