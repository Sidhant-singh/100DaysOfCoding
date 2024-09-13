class Solution {
    public int ways(int idx ,int[] nums, int target) {
        if(idx==nums.length){
            if(target==0) return 1;
            else return 0;
        }
        
        int add = ways(idx+1,nums,target-nums[idx]);
        int sub = ways(idx+1,nums,target+nums[idx]);
        
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return ways(0,nums,target);
    }
}