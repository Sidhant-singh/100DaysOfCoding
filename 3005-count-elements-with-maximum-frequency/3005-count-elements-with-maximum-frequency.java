class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count frequencies of elements
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Find maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }
        
        // Count elements with maximum frequency
        int count = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency == maxFrequency) {
                count++;
            }
        }
        
        return count * maxFrequency;
    }
}