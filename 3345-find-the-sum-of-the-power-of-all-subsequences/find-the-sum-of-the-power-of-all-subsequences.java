class Solution {
    /*
    2 --> 5 
    2 * 2 --> 2 == 4
    */
    Long dp[][][];
    long mod = 1_000_000_007;
    private long power(long base,long power){
        if(power == 0) return 1;
        long ans = 1;
        while(power > 0){
            ans = base * ans;
            ans = ans % mod;
            power--;
        }
        return ans;
    }
    private long helper(int idx,int nums[],int count,int k){
        if(k == 0){
            return (long) power(2,nums.length - count);
        }
        if(idx == nums.length ||  k < 0){
            return 0;
        }
        if(dp[idx][count][k] != null){
            return dp[idx][count][k];
        }
        long pick = helper(idx + 1,nums,count+1,k-nums[idx]) % mod;
        long dont = helper(idx + 1,nums,count,k) % mod;
        dp[idx][count][k] = (pick + dont) % mod;
        return dp[idx][count][k];
    }
    public int sumOfPower(int[] nums, int k) {
        System.out.println(5+" "+power(2,5));
        dp = new Long[nums.length + 1][nums.length + 1][k + 1];
        return (int) helper(0,nums,0,k);
    }
}