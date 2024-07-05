class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []arr = {-1,-1};
        int n = nums.length;
        int low = 0;
        int high = n-1;
        boolean flag = false; //element not present
//         check the element wheather it is present or not
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                flag = true;
                break;
            }
            else if(nums[mid]<target) low=mid+1;
            else if(nums[mid]>target) high=mid-1;
        }
        if(flag==false) return arr;
        
//         find the lower Bound of the target
        low = 0;
        high = n-1;
        int lb = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>=target){
                lb = Math.min(lb,mid);
                high = mid-1;
            }
            else low = mid+1;
        }
        arr[0] = lb;
//         find the upper Bound of the target
        low = 0;
        high = n-1;
        int ub = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>target){
                ub = Math.min(ub,mid);
                high = mid-1;
            }
            else low = mid+1;
        }
        arr[1] = ub-1;
        return arr;
    }
}