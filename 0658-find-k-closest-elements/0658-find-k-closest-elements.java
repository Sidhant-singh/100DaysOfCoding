class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
//         if the target is less than the first element then we have to return first k elements
        if(x<arr[0]){
            for(int i=0;i<k;i++){
                res.add(arr[i]);
            }
            return res;
        }
//         if the target is more than the last element then we have to return last n-k elements
        if(x>arr[n-1]){
            for(int i=n-1;i>=n-k;i--){
                res.add(arr[i]);
            }
            Collections.sort(res);
            return res;
        }
        
//         finding the lower bound
        int lb = n;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=x){
                lb = mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        
//         placing the pointer wrt to lb
        int i = lb-1;
        int j = lb;
        
        while(i>=0 && j<n && k>0){
            int di = Math.abs(x-arr[i]);
            int dj = Math.abs(x-arr[j]);
            if(di<=dj){
                res.add(arr[i]);
                i--;
               
            }
            else{
                res.add(arr[j]);
                j++;
                
            }
            k--;
        }
        
//         now this can happen that there are some elements left and the pointers approaches to end
        while(i<0 && k>0){
            res.add(arr[j]);
            j++;
            k--;
        }
        
        while(j==n && k>0){
            res.add(arr[i]);
            i--;
            k--;
        }
        
        Collections.sort(res);
        return res;
    }
}