class Solution {
    public int minPatches(int[] nums, int n) {
        long s = 0;
        int p = 0;
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(s < i){
                while(p < nums.length && nums[p] <= i){
                    s = s + nums[p];
                    p++;
                }
            }
            if(s < i){
                ans++;
                s = s + i;
            }
            if(s < n)
            i = (int) s;
            if(s >= n){
                break;
            }
        }
        return ans;
    }
}