class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int maxsum = 0;
        for(int i=0;i<k;i++){
            maxsum += arr[i];
        }
        
        int windowSum = maxsum;
        int count = 0;
        if(windowSum/k >= threshold) count++;
        for(int i=k;i<n;i++){
            windowSum += arr[i] - arr[i-k];
            if(windowSum/k >= threshold) count++;
        }
        
        return count;
    }
}