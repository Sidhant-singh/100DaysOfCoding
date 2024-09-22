class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--; // Since we start with the first number, reduce k by 1

        while (k > 0) {
            int steps = countSteps(n, current, current + 1); // Count how many numbers are between current and current + 1
            if (steps <= k) {
                // If the kth number is not within this prefix range, move to the next sibling
                current++;
                k -= steps;
            } else {
                // If the kth number is within this prefix range, go deeper into this subtree
                current *= 10;
                k--; // We've accounted for the current number, move on to the next
            }
        }

        return current;
    }

    // Function to count how many numbers are between prefix and nextPrefix
    private int countSteps(int n, long prefix, long nextPrefix) {
        int steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix; // Count numbers between prefix and nextPrefix
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }
}
