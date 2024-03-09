class Solution {
    private int countDiv(Map<Integer,List<int []>> graph,int src,Set<Integer> visited,int dis,int mod){
        int ans = 0;
        visited.add(src);
        if(dis % mod == 0){
            ans++;
        }
        for(int i[] : graph.get(src)){
            if(!visited.contains(i[0]))
            {
                ans = ans + countDiv(graph,i[0],visited,dis + i[1],mod);
            }
        }
        return ans;
    }
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        Map<Integer,List<int []>>  graph = new HashMap<>();
        int n = edges.length + 1;
        for(int i = 0; i < n ; i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            int wgt = edges[i][2];
            graph.get(src).add(new int[]{dst,wgt});
            graph.get(dst).add(new int[]{src,wgt});
        }
        int ans[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            int cnt = 0;
            for(int j[] : graph.get(i)){
                int t = countDiv(graph,j[0],visited,j[1],signalSpeed);
                if(cnt == 0){
                    cnt = t;
                }else{
                    ans[i] = ans[i] + cnt * t;
                    cnt = cnt + t;
                }
            }
        }
        return ans;
    }
}