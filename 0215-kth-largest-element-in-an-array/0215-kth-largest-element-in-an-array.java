class Solution {
    static int ans;
    
    public void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int partition(int []arr,int low,int high){
        int pivot = arr[low];
        int smallerCount=0;
        for(int i=low+1;i<=high;i++){
            if(arr[i]<=pivot) smallerCount++;
        }
        
        int correctIdx = low + smallerCount;
        
        swap(arr,correctIdx,low);
        
        int i=low;
        int j=high;
        
        while(i<correctIdx && j>correctIdx){
            if(arr[i]<=pivot) i++;
            else if(arr[j]>pivot) j--;
            else if(arr[i]>pivot && arr[j]<=pivot){
                swap(arr,i,j);
            }
        }
        
        return correctIdx;
    }
    public void quickSelect(int []arr,int low,int high,int k){
        if(low>high) return;
        
        int idx = partition(arr,low,high);
        
        if(idx==k-1){
            ans = arr[idx];
            return;
        }
        if(k-1<idx) quickSelect(arr,low,idx-1,k);
        else quickSelect(arr,idx+1,high,k);
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        ans = -1;
        quickSelect(nums,0,n-1,n-k+1);
        return ans;
    }
}