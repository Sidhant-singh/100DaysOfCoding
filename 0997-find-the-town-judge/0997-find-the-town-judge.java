class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCounts = new int[n + 1]; // Array to count the number of people who trust each person
        boolean[] trustedBy = new boolean[n + 1]; // Array to track if a person is trusted by everyone
        
        // Count the number of people who trust each person and mark who trusts someone
        for (int[] pair : trust) {
            int a = pair[0];
            int b = pair[1];
            trustCounts[b]++;
            trustedBy[a] = true;
        }
        
        // Find the person who is trusted by everyone but trusts no one
        for (int i = 1; i <= n; i++) {
            if (trustCounts[i] == n - 1 && !trustedBy[i]) {
                return i; // Found the town judge
            }
        }
        
        return -1;
    }
}