class Solution {
    Boolean dp[][];
    private boolean helper(int idx,int aSum,int sum,int nums[]){
        if(idx == nums.length){
            return sum - aSum == aSum;
        }
        if(dp[aSum][idx] != null){
            return dp[aSum][idx];
        }
        boolean aGet = helper(idx + 1, aSum + nums[idx] , sum + nums[idx] , nums);
        boolean bGet = helper(idx + 1, aSum , nums[idx] + sum , nums);
        return dp[aSum][idx] = aGet || bGet;
    }
    public boolean canPartition(int[] nums) {
        dp = new Boolean[2_00_01][nums.length];
        return helper(0,0,0,nums);
    }
}