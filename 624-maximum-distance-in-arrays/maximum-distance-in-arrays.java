class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int in = 0;
        int tmin = Integer.MAX_VALUE;
        int tmax = Integer.MIN_VALUE;
        for(List<Integer> i : arrays){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j : i){
                min = Math.min(min,j);
                max = Math.max(max,j);
            }
            if(tmax != Integer.MIN_VALUE)
            ans = Math.max(ans,Math.max(tmax - min,max - tmin));
            tmin = Math.min(min,tmin);
            tmax = Math.max(max,tmax);
            in++;
        }
        return ans;
    }
}