class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the start or end is an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // Initialize DP table
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 0 ? dp[0][j - 1] : 0;
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i - 1][0] : 0;
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // The number of unique paths to the bottom-right corner
        return dp[m - 1][n - 1];
    }
}    
