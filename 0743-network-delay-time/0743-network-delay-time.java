class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int distance;

        Pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
        public int compareTo(Pair p){
            if(this.distance==p.distance) return this.node - p.node;
            return this.distance - p.distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adj.get(u).add(new Pair(v,time));
        }
//        Now applying dijkstra alogorithm
//        Array for storing the minimum time
        int []ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while(pq.size()>0){
            Pair top = pq.poll();
            int node = top.node;
            int time = top.distance;
            if(top.distance > ans[node]) continue;
            for(Pair p : adj.get(node)){
//                distance -> time
                int totalTime = top.distance + p.distance;
                if(totalTime<ans[p.node]){
                    ans[p.node] = totalTime;
                    pq.add(new Pair(p.node,totalTime));
                }
            }
        }
        int max = -1;
        for(int i=1;i<=n;i++){
            if(ans[i] == Integer.MAX_VALUE ) return -1;
            max = Math.max(max,ans[i]);
        }
        return max;
    }
}