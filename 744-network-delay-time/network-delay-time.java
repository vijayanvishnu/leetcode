class Pair{
    int node;
    int cost;
    Pair(int node,int cost){
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        List<Pair> graph[] = new ArrayList[n + 1];
        int cost[] = new int[n + 1];
        Arrays.fill(cost,Integer.MAX_VALUE/2);
        cost[k] = cost[0] = 0;
        for(int i = 0 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length ; i++){
            int srt = edges[i][0];
            int dst = edges[i][1];
            int cst = edges[i][2];
            graph[srt].add(new Pair(dst,cst));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new Pair(k,0));
        int ans = 0;
        while(pq.size() > 0){
            Pair poll = pq.poll();
            for(Pair i : graph[poll.node]){
                if(cost[i.node] > poll.cost + i.cost){
                    cost[i.node] = poll.cost + i.cost;
                    pq.add(new Pair(i.node,cost[i.node]));
                }
            }
        }
        for(int i : cost){
            ans = Math.max(ans,i);
        }
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}