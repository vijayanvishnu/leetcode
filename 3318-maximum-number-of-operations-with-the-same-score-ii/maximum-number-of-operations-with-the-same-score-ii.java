class Solution {
    Integer dp[][][];
    private int helper(int left,int right,int nums[],int prev){
        if(right - left < 1){
            return 0;
        }
        int firstTwo , lastTwo , firstLast = lastTwo = firstTwo = 0;
        if(nums[left] + nums[left + 1] == prev){ 
            if(dp[0][left][right] != null) return dp[0][left][right];
            firstTwo = 1 + helper(left + 2 , right, nums,prev);
            dp[0][left][right] = firstTwo;
        }
        if(nums[right] + nums[right - 1] == prev){
            if(dp[1][left][right] != null) return dp[1][left][right];
            lastTwo = 1 + helper(left , right - 2 , nums , prev);
            dp[1][left][right] = firstTwo;
        }
        if(nums[right] + nums[left] == prev){
            if(dp[2][left][right] != null) return dp[2][left][right];
            firstLast = 1 + helper(left + 1, right - 1 ,nums , prev);
            dp[2][left][right] = firstTwo;
        }
        return Math.max(firstTwo,Math.max(lastTwo,firstLast));
    }
    public int maxOperations(int[] nums) {
        dp = new Integer[3][nums.length][nums.length];
        int f = helper(0,nums.length - 1,nums,nums[0] + nums[1]);
        int s = helper(0,nums.length - 1,nums,nums[nums.length - 2] + nums[nums.length - 1]);
        int t = helper(0,nums.length - 1,nums,nums[0] + nums[nums.length - 1]);
        return Math.max(f,Math.max(s,t));
    }
}