class Solution {
    public int findChampion(int n, int[][] edges) {
        // Initialize an array to store the in-degree of each node
        int[] inDegree = new int[n];
        // Initialize an adjacency list for the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build the graph and calculate in-degrees
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            inDegree[v]++;
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
        }

        // Find all nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // If there's more than one node with in-degree 0, return -1
        if (queue.size() != 1) return -1;

        // Perform BFS starting from the potential champion
        int champion = queue.poll();
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(champion);
        int visitedNodes = 0;

        while (!bfsQueue.isEmpty()) {
            int curr = bfsQueue.poll();
            visitedNodes++;

            for (int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    bfsQueue.add(neighbor);
                }
            }
        }

        // If not all nodes are visited, or there are unreachable nodes, return -1
        return visitedNodes == n ? champion : -1;
    }
}
