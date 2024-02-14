class Solution {
    Integer dp[][];
    private int helper(int idx, int nums[],int k){
        if(idx == nums.length){
            return k >= 0 ? 0 : -1_00_000;
        }
        if(k < 0) return -1_00_000;
        if(dp[k][idx] != null) return dp[k][idx];
        int max = nums[idx];
        int min = nums[idx];
        int profit = 0;
        int ans = 0;
        for(int i = idx ; i < nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
                max = min;
            }
            if(max < nums[i]){
                max = nums[i];
            }
            profit = Math.max(profit  , max - min);
            ans = Math.max(ans , profit +  helper(i  + 1 , nums, k - 1));
        }
        return dp[k][idx] = ans;
    }
    public int maxProfit(int k, int[] prices) {
        dp = new Integer[k + 1][prices.length];
        return helper(0,prices,k);
    }
}