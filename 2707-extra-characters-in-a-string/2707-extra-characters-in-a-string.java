class Solution {
    public int minExtraChar(String s, String[] dict) {
       Set<String> dictionary = new HashSet<>(Arrays.asList(dict)); // Store dictionary in a set for quick lookup
        int n = s.length();

        // dp[i] will store the minimum extra characters from index i to the end of the string
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: no extra characters if the string is empty (dp[n] = 0)
        dp[n] = 0;

        // Traverse the string from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Assume all characters from i to the end are extra (worst case scenario)
            dp[i] = dp[i + 1] + 1;
            
            // Try all substrings starting at index i
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);

                // If the substring is in the dictionary, check the remaining string
                if (dictionary.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        // The answer is the minimum extra characters starting from the first index (dp[0])
        return dp[0];
    }
}