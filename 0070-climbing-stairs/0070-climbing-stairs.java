class Solution {
    public int helper(int idx,int n,int[]dp){
        if(idx>n) return 0;
        if(idx==n) return 1;
        if(dp[idx]!=0) return dp[idx];
        dp[idx] = helper(idx+1,n,dp) + helper(idx+2,n,dp);
        return dp[idx];
    }
    public int climbStairs(int n) {
        int []dp  = new int[n+1];
        return helper(0,n,dp);
    }
}