class Solution {
public boolean canArrange(int[] arr, int k) {
        // Create an array to count the frequencies of remainders
        int[] remainderCounts = new int[k];
        
        // Traverse through each number in the array
        for (int num : arr) {
            // Calculate the remainder when the number is divided by k
            int remainder = num % k;
            // Make sure the remainder is positive
            if (remainder < 0) {
                remainder += k;
            }
            remainderCounts[remainder]++;
        }

        // Check if we can form valid pairs
        for (int i = 0; i <= k / 2; i++) {
            if (i == 0) {
                // Numbers with remainder 0 must be paired among themselves
                if (remainderCounts[i] % 2 != 0) {
                    return false;
                }
            } else {
                // For each remainder i, there must be equal numbers with remainder k - i
                if (remainderCounts[i] != remainderCounts[k - i]) {
                    return false;
                }
            }
        }

        return true;        
    }
}