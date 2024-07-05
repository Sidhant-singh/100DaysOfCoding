class Solution {
    public int[] searchRange(int[] arr, int target) {
        int []res = {-1,-1};
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int first = -1;
        int last = -1;
//         finding the first occurrence
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                if(mid>0 && arr[mid] == arr[mid-1]) high = mid-1;
                else {
                    first = mid;
                    break;
                }
            }
            
            else if(arr[mid]>target){
                high = mid-1;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
        }
        res[0] = first;
//         finding the last occurrence
        low = 0;
        high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                if(mid+1<n && arr[mid] == arr[mid+1]) low = mid+1;
                else {
                    last = mid;
                    break;
                }
            }
            
            else if(arr[mid]>target){
                high = mid-1;
            }
            else if(arr[mid]<target){
                low = mid+1;
            }
        }
        res[1] = last;
        return res;
        
        
    }
}