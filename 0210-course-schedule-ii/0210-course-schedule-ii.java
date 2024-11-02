import java.util.*;

class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        
        for (int[] pair : pre) {
            int a = pair[0];
            int b = pair[1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        
        // Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        // Add all nodes with indegree 0 to the queue
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);
            for (int neighbor : adj.get(front)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        // Convert list `ans` to array
        if (ans.size() != n) return new int[0]; // Return empty array if not all courses can be finished
        
        int[] ans2 = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans2[i] = ans.get(i);
        }
        
        return ans2;
    }
}
