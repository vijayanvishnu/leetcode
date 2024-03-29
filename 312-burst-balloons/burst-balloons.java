class Solution {
    Integer dp[][];
    private int helper(int nums[],int l,int r)
    {
        if(l>=r){
            return 0;
        }
        if(dp[l][r] != null){
            return dp[l][r];
        }
        int ans = 0;
        for(int i = l + 1 ; i < r ; i++){
            int curr = nums[i] * nums[l] * nums[r];
            ans = Math.max(ans,helper(nums,l,i)+helper(nums,i,r)+curr);
        }
        return dp[l][r] = ans;
    }
    public int maxCoins(int[] given) {
        int nums[] = new int[given.length + 2];
        nums[0] = nums[nums.length - 1] = 1;
        dp = new Integer[nums.length][nums.length];
        for(int i = 0 ; i < given.length ; i++){
            nums[i + 1] = given[i];
        }
        int ans = helper(nums,0,nums.length - 1);
        return ans;
    }
}