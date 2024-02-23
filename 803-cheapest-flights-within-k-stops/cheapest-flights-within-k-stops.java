class Solution {
    boolean visited[];
    int dest = 0;
    Integer dp[][];
    private int helper(int start , Map<Integer,List<int []>> graph , int k){
        if(k < -1){
            return 1_00_000_0;
        }
        if(start == dest){
            return 0;
        }
        if(dp[start][k + 1] != null){
            return dp[start][k + 1];
        }
        // visited[start] = true;
        int ans = 1_00_000_0;
        for(int i[] : graph.get(start)){
            if(!visited[i[0]]){
                ans = Math.min(ans,i[1] + helper(i[0] , graph, k - 1));
            }
        }
        // visited[start] = false;
        return dp[start][k+ 1] = ans;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        visited = new boolean[n];
        this.dest = dst;
        dp = new Integer[n][k + 2];
        Map<Integer,List<int []>> graph = new HashMap<>();
        for(int i = 0; i < n ; i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i = 0 ; i < flights.length ; i++){
            int isrc = flights[i][0];
            int idst = flights[i][1];
            int cost = flights[i][2];
            graph.get(isrc).add(new int[]{idst,cost});
        }
        int ans = helper(src,graph,k);
        return (ans >= 1_000_000 ? -1 : ans);
    }
}