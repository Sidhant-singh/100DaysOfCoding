class Solution {
    
    public boolean isPossible(int maxQ,int []arr,int n){
        int stores = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%maxQ==0) stores += arr[i]/maxQ;
            else stores += arr[i]/maxQ + 1;
        }
        if(stores>n) return false;
        else return true;
    }
    public int minimizedMaximum(int n, int[] arr) {
        int m = arr.length;
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            mx = Math.max(mx,arr[i]);
        }
        
        int low = 1;
        int high = mx;
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(mid,arr,n)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        
        return ans;
    }
}