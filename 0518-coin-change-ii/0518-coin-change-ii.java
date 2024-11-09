class Solution {
    public int count(int idx,int amount,int []coins,int [][]dp){
        if (amount == 0) {
            return 1;
        }
        if (idx == coins.length || amount < 0) {
            return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];

        int take = count(idx, amount - coins[idx], coins,dp);
        
        int skip = count(idx + 1, amount, coins,dp);
        
        return dp[idx][amount] = take + skip;
        
    }
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return count(0,amount,coins,dp);
    }
}