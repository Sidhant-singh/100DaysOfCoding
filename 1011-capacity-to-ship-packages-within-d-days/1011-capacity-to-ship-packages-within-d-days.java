class Solution {
    public boolean isPossible(int c,int []arr,int d){
        int n = arr.length;
        int days = 1;
        int load = 0;
        for(int i=0;i<n;i++){
            if(load + arr[i]<=c) load+= arr[i];
            else{
                load = arr[i];
                days++;
            }
        }
        
        if(days>d) return false;
        else return true;
    }
    public int shipWithinDays(int[] arr, int days) {
        int n = arr.length;
        int mx=arr[0];
        int sum =0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            mx = Math.max(mx,arr[i]);
        }
        int low = mx;
        int high = sum;
        int minC = sum;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(mid,arr,days)){
                minC = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return minC;
    }
}