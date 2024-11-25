class Solution {
    public int slidingPuzzle(int[][] board) {
        // Define the solved state as a string
        String target = "123450";
        
        // Convert the initial board into a string representation
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }
        
        // Define valid moves for each position
        int[][] moves = {
            {1, 3},        // 0 -> can swap with 1, 3
            {0, 2, 4},     // 1 -> can swap with 0, 2, 4
            {1, 5},        // 2 -> can swap with 1, 5
            {0, 4},        // 3 -> can swap with 0, 4
            {1, 3, 5},     // 4 -> can swap with 1, 3, 5
            {2, 4}         // 5 -> can swap with 2, 4
        };

        // Use a queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(start.toString());

        // Use a set to keep track of visited states
        Set<String> visited = new HashSet<>();
        visited.add(start.toString());

        // Perform BFS
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return steps; // Solved

                // Find the position of '0'
                int zeroIndex = current.indexOf('0');
                
                // Explore all possible moves
                for (int next : moves[zeroIndex]) {
                    String nextState = swap(current, zeroIndex, next);
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.add(nextState);
                    }
                }
            }
            steps++;
        }

        // If the target is not reached, return -1
        return -1;
    }

    // Helper function to swap two characters in a string
    private String swap(String state, int i, int j) {
        char[] arr = state.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}