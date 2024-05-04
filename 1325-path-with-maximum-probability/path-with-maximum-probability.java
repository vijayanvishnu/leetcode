class Pair{
    int node;
    double cost;
    Pair(int node,double cost){
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair> graph[] = new ArrayList[n + 1];
        double cost[] = new double[n + 1];
        Arrays.fill(cost,0.0);
        for(int i = 0 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length ; i++){
            int srt = edges[i][0];
            int dst = edges[i][1];
            double cst = succProb[i];
            graph[srt].add(new Pair(dst,cst));
            graph[dst].add(new Pair(srt,cst));
        }
        
        //dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.cost,a.cost));
        pq.add(new Pair(start,1.0));
        int ans = 0;
        while(pq.size() > 0){
            Pair poll = pq.poll();
            for(Pair i : graph[poll.node]){
                if(cost[i.node] < poll.cost * i.cost){
                    cost[i.node] = poll.cost * i.cost;
                    pq.add(new Pair(i.node,cost[i.node]));
                }
            }
        }
        return cost[end];
    }
}