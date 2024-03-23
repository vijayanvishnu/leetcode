class Solution {
    Long dp[];
    long mod = 1_000_000_007;
    private Long helper(int one,int zero, int n){
        if(n == 0){
            return 1l;
        }
        if(n < 0){
            return 0l;
        }
        if(dp[n] != null){
            return dp[n];
        }
        return dp[n] = (helper(one , zero , n - one) + helper( one , zero , n - zero)) % mod;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new Long[high + 1];
        dp[high] = helper(one,zero,high);
        long ans = 0;
        while(low <= high){
            if(dp[low] == null){
                dp[low] = helper(one,zero,low);
            }
            ans = ans + dp[low];
            ans = ans % mod;
            low++;
        }
        return (int) ans;
    }
}