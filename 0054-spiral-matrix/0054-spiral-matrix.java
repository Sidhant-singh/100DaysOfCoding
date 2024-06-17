class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int minr = 0, maxr = m - 1;
        int minc = 0, maxc = n - 1;

        while (minr <= maxr && minc <= maxc) {
            // left to right
            for (int j = minc; j <= maxc; j++) {
                result.add(matrix[minr][j]);
            }
            minr++;

            // top to bottom
            if (minr>maxr || minc>maxc) break;{
                for (int i = minr; i <= maxr; i++) {
                    result.add(matrix[i][maxc]);
                }
                maxc--;
            }

            // right to left
            if (minr>maxr || minc>maxc) break;{
                for (int j = maxc; j >= minc; j--) {
                    result.add(matrix[maxr][j]);
                }
                maxr--;
            }

            // bottom to top
            if (minr>maxr || minc>maxc) break;{
                for (int i = maxr; i >= minr; i--) {
                    result.add(matrix[i][minc]);
                }
                minc++;
            }
        }

        return result;
    }
}
