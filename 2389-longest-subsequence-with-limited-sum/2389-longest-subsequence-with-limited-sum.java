class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
//         sorted the array
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
//         finding the prefix sum 
        for(int i=1;i<n;i++){
            nums[i] += nums[i-1];
        }
        int []ans = new int[m];
//         applying binary search on prefix sum array for each element of queries
        for(int i=0;i<m;i++){
            int low = 0,hi =n-1;
            while(low<=hi){
                int mid = low + (hi-low)/2;
                if(nums[mid]>queries[i]) hi = mid-1;
                else{
                    ans[i] = Math.max(ans[i],mid+1);
                    low = mid+1;
                }
            }
        }
        return ans;
    }
}