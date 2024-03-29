class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        long start = 1;
        long end = x;
        long ans = 0;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid + 1;
                ans = mid; // Update the potential answer
            } else {
                end = mid - 1;
            }
        }
        
        return (int)ans;
    }
}