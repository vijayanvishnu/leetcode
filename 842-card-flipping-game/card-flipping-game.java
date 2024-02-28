class Solution {
    public int helper(int[] fronts, int[] backs) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < backs .length ; i++){
            if(fronts[i] == backs[i]){
                set.add(fronts[i]);
            }else{
                map.putIfAbsent(fronts[i],new HashSet<>());
                map.get(fronts[i]).add(i);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < backs.length ; i++){
            if(!set.contains(backs[i])){
                Set<Integer> get = map.get(backs[i]);
                boolean found = true;
                if(get !=  null){
                    for(int j : get){
                        if(fronts[j] == backs[j]){
                            found = false;
                        }
                    }
                }
                set.add(backs[i]);
                if(found){
                    ans = Math.min(ans,backs[i]);
                }
            }
        }
        return ans;
    }
    public int flipgame(int[] fronts, int[] backs) {
        int a = helper(fronts,backs);
        int b = helper(backs,fronts);
        int ans = Math.min(a,b);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}