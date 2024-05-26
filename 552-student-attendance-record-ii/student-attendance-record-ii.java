class Solution {
    long mod = (long) 1e9 + 7;
    Long dp[][][];
    private long helper(int n, int abs, int prevLates){
        if(n == 0){
            return 1;
        }
        if(dp[abs][prevLates][n] != null){
            return dp[abs][prevLates][n];
        }
        long ans = 0;
        if(prevLates < 2){
            ans = helper(n - 1, abs , prevLates + 1);
        }
        if(abs < 1){
            ans = ans + helper(n - 1 , abs + 1 , 0);
        }
        ans = ans + helper(n - 1, abs , 0);
        return dp[abs][prevLates][n] = ans % mod;
    }
    public int checkRecord(int n) {
        dp = new Long[2][3][n + 1];
        return (int) helper(n , 0 ,0);
    }
}