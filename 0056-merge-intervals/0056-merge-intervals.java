import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals by their start times
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // Step 2: Initialize a list to store merged intervals
        List<int[]> ans = new ArrayList<>();
        
        for (int[] inter : intervals) {
            // Step 3: Check if the list is empty or if the current interval does not overlap
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < inter[0]) {
                ans.add(inter); // Add non-overlapping interval
            } else {
                // Step 4: Merge intervals by updating the end time of the last interval
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], inter[1]);
            }
        }

        // Step 5: Convert the list to a 2D array and return
        return ans.toArray(new int[ans.size()][]);
    }
}
