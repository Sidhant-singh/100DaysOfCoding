class Solution {
    public int findMaxLength(int[] nums) {
        // Create a HashMap to store the running sum and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with sum 0 at index -1
        int maxLen = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // Increment count if current element is 1, otherwise decrement
            count += (nums[i] == 1) ? 1 : -1;

            // Check if the current count has been encountered before
            if (map.containsKey(count)) {
                // If yes, update maxLen with the difference of current index and the index where count was encountered before
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                // If not, add the count and its index to the map
                map.put(count, i);
            }
    }
        
        return maxLen;
    }
}