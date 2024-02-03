class Solution {
    Integer dp[];
    private int helper(int idx , int k , int nums[]){
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        int res = 0;
        int max = 0;
        for(int i = 0 ; i < k ; i++){
            if(idx + i < nums.length){
                max = Math.max(max , nums[idx + i]);
                res = Math.max(res , max * (i+1) + helper(idx + i + 1, k ,nums));
            }
        }
        return dp[idx] = res;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return helper(0,k,arr);
    }
}