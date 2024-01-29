package solving100DaysOfCode;

import java.util.Arrays;

/*Given an array of N integers where each value represents the number of chocolates in a packet. 
Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 

Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates 
given to the students is minimum. */
public class chocolateDistribution {

    public static int minValueOfDistribution(int []arr, int m){
        Arrays.sort(arr);
        int n = arr.length;
        if(arr.length == 0 || m==0){
            return 0;
        }
        int min_diff = Integer.MAX_VALUE;
        for(int i=0;i<n-m-1;i++){
            int next_window = m+i-1;
            int difference = arr[next_window] - arr[i];
            min_diff = Math.min(min_diff, difference);
        }
        return min_diff;
    }
    public static void main(String[] args) {
        int [] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int m = 5;
        System.out.println(minValueOfDistribution(arr, m));

    }
}

/*Initially sort the given array. And declare a variable to store the minimum difference, and initialize it to INT_MAX. 
Let the variable be min_diff.
Find the subarray of size m such that the difference between the last (maximum in case of sorted) 
and first (minimum in case of sorted) elements of the subarray is minimum.
We will run a loop from 0 to (n-m), where n is the size of the given array and m is the size of the subarray.
We will calculate the maximum difference with the subarray and store it in diff = arr[highest index] – arr[lowest index]
Whenever we get a diff less than the min_diff, we will update the min_diff with diff. */
