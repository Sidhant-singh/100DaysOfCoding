class Solution {
    private boolean subset(int i,int []arr,int target,int [][]dp){
        if(i<0){
            if(target==0) return true;
            else return false;
        }

        if(dp[i][target]!=-1){
            if(dp[i][target] == 1) return true;
            else return false;
        }

        boolean ans = false;
        boolean skip = subset(i-1,arr,target,dp);
        if(target-arr[i]<0){ //only valid for positive numbers
            ans = skip;
         }
        else{
            boolean pick = subset(i-1,arr,target-arr[i],dp);
            ans = pick || skip;
        }
        if(ans) dp[i][target] = 1;
        else dp[i][target] = 0;
        return ans;
    }
    
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele : nums){
            sum += ele;
        }
        int n = nums.length;
        if(sum%2!=0) return false;
        
        int target = sum/2;
        int [][]dp = new int[nums.length][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return subset(n-1,nums,target,dp);
    }
}