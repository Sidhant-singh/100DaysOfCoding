class Solution {
    static int sum;
    public int ways(int idx ,int[] nums,int res, int target,int [][] dp) {
        if(idx==nums.length){
            if(res==target) return 1;
            else return 0;
        }
        if(dp[idx][res+sum]!=-1) return dp[idx][res+sum]; 
        int add = ways(idx+1,nums,res+nums[idx],target,dp);
        int sub = ways(idx+1,nums,res-nums[idx],target,dp);
        
        return dp[idx][res+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        int n=nums.length;
        for(int ele : nums){
            sum += ele;
        }
//         i - 0 to n-1 || target -> -sum to +sum
//         dp[i][target+sum] -> ways(i,target)
//         in some cases the target of the value of goes in negative and we have to 
//         store the negative values and the array can't store negative values 
//         so we have taken 2*sum + 1 as target range is always -sum to +sum
        int [][] dp = new int[n][2*sum+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return ways(0,nums,0,target,dp);
    }
}