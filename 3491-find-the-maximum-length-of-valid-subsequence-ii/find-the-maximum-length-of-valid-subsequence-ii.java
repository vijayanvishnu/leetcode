class Solution {
    public int maximumLength(int[] nums, int k) {
        int dp[][] = new int[nums.length][k];
        int ans = 0;
        for(int i = nums.length - 1 ; i > -1 ; i--){
            for(int j = i + 1 ; j < nums.length ; j++){
                int sum = nums[i] + nums[j];
                int rem = sum % k;
                dp[i][rem] = Math.max(dp[i][rem] , 1 + dp[j][rem]);
                ans = Math.max(ans,dp[i][rem]);
            }
        }
        return ans > 0 ? ans + 1 : 0;
    }
}