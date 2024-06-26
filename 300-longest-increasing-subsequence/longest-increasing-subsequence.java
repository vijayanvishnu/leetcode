class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int max = 1;
        Arrays.fill(dp,1);
        for(int i = 1; i < nums.length ; i++){
            for(int j = i - 1 ; j > -1 ; j--){
                if(nums[i] > nums[j])
                dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}