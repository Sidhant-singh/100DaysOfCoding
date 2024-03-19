class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        
        // Count the frequency of each task
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        // Sort the frequencies array to get the maximum frequency task
        Arrays.sort(frequencies);
        
        // Get the maximum frequency task
        int maxFreq = frequencies[25] - 1;
        
        // Calculate the number of empty slots
        int idleSlots = maxFreq * n;
        
        // Fill the empty slots with other tasks
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleSlots -= Math.min(frequencies[i], maxFreq);
        }
        
        // If there are more empty slots than tasks, return the total length
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}