class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int count[] =  new int[n];
        for(int i = 0 ; i < roads.length ; i++){
            int src = roads[i][0];
            int dst = roads[i][1];
            count[src]++;
            count[dst]++;
        }
        long ans = 0;
        Arrays.sort(count);
        long curr = 1;
        for(int i = 0 ; i < n ; i++){
            ans = ans + curr * count[i];
            curr++;
        }
        return ans;
    }
}