class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen  = Integer.MAX_VALUE;
        int i=0,j=0,sum=0;
//        first window
        while(j<n && sum<target){
            sum += nums[j++];
        }
//        j hmeshsa aage nikal jata h 
        j--;
//        sliding window
        while(i<n && j<n){
            int len = j-i+1;
            if(sum>=target) minLen = Math.min(len,minLen);
            sum -= nums[i];
            i++;j++;
            while(j<n && sum<target){
                sum += nums[j++];
            }
            j--;
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}