import java.util.*;

class Solution {
    static boolean ans;
    
    public void bfs(int i, int[][] adj, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        vis[i] = 0; // Start coloring the node with color 0 (blue)
        q.add(i);
        
        while (!q.isEmpty()) {
            int front = q.poll();
            int color = vis[front];
            
            for (int neighbor : adj[front]) {
                if (vis[neighbor] == color) {
                    // If the neighboring node has the same color, it’s not bipartite
                    ans = false;
                    return;
                }
                if (vis[neighbor] == -1) {
                    // Color the neighbor with the opposite color
                    vis[neighbor] = 1 - color;
                    q.add(neighbor);
                }
            }
        }
    }

    public boolean isBipartite(int[][] adj) {
        ans = true;
        int n = adj.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1); // Initialize all nodes as unvisited
        
        // Traverse each node, in case of disconnected graph components
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) { // If the node hasn't been visited
                bfs(i, adj, vis);
                if (!ans) return false; // Early return if a component is not bipartite
            }
        }
        
        return ans;
    }
}
