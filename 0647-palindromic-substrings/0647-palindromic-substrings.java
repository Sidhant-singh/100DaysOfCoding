class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        // Create a 2D array to store whether substring i to j is a palindrome
        boolean[][] dp = new boolean[n][n];
        
        // Each individual character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        
        // Check for palindromic substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        
        // Check for palindromic substrings of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}