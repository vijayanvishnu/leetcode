class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> path = new HashMap<>();
        Map<Integer,Integer> changed = new HashMap<>();
        int ans[] = new int[queries.length];
        for(int i = 0 ; i < queries.length ; ++i){
            int x = queries[i][0];
            int y = queries[i][1];
            if(changed.containsKey(x)){
                int clr = changed.get(x);
                int clrFreq = path.getOrDefault(clr,0);
                if(clrFreq <= 1){
                    path.remove(clr);
                }else{
                    path.put(clr,clrFreq - 1);
                }
            }
            path.put(y,path.getOrDefault(y,0) + 1);
            ans[i] = path.size();
            changed.put(x,y);
        }
        return ans;
    }
}