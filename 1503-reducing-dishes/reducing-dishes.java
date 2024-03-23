class Solution {
    Integer dp[][];
    private int helper(int idx,int picks,int nums[]){
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx][picks] != null){
            return dp[idx][picks];
        }
        int pick = picks * nums[idx] + helper(idx + 1, picks + 1 , nums);
        int dont =  helper(idx + 1, picks , nums);
        return dp[idx][picks] = Math.max(dont,pick);
    }
    public int maxSatisfaction(int[] satisfaction) {
        dp = new Integer[satisfaction.length][satisfaction.length + 1];
        Arrays.sort(satisfaction);
        return helper(0,1,satisfaction);
    }
}