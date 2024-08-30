class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int []ans = new int[n];
        for(int i=0;i<bookings.length;i++){
            int first = bookings[i][0];
            int last = bookings[i][1];
            int seats = bookings[i][2];
            for(int j=first-1;j<=last-1;j++){
                ans[j] += seats;
            }
        }
        
        return ans;
    }
}