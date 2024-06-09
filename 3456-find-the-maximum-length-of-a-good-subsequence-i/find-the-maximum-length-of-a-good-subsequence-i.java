class Solution {
    Integer dp[][][];
    private int helper(int nums[],int prev,int idx , int k){
        if(idx == nums.length){
            return 0;
        }
        if(dp[k][prev + 1][idx] != null){
            return dp[k][prev + 1][idx];
        }
        int ans = 0;
        if(prev != -1 && nums[prev] != nums[idx] ){
            if(k > 0)
            ans = 1 + helper(nums , idx , idx + 1 , k - 1);
        }else{
            ans = 1 + helper(nums , idx , idx + 1 , k);
        }
        ans = Math.max(ans , helper(nums , prev , idx + 1 , k));
        return dp[k][prev + 1][idx] = ans;
    }
    public int maximumLength(int[] nums, int k) {
        dp = new Integer[k + 1][nums.length + 1][nums.length];
        return helper(nums , -1 , 0 , k);
    }
}