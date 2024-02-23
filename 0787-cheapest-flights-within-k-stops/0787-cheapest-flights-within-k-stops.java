class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1_000_000_000;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;
        
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (cost[from] != INF && cost[from] + price < temp[to]) {
                    temp[to] = cost[from] + price;
                }
            }
            cost = temp;
        }
        
        return cost[dst] == INF ? -1 : cost[dst];
    }
}