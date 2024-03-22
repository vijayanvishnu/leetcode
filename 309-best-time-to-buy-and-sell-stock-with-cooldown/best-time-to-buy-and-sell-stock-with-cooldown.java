class Solution {
    Integer dp[];
    private int helper(int idx, int nums[]){
        if(idx >= nums.length){
            return 0;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        int ans = helper(idx + 1, nums);
        for(int i = idx + 1; i < nums.length ; i++){
            ans = Math.max(ans,nums[i] - nums[idx] + helper(i + 2,nums));
        }
        return dp[idx] = ans;
    }
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length];
        return helper(0,prices);
    }
}