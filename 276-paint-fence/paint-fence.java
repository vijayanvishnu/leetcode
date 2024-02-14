class Solution {
    Integer dp[][][];
    private int helper(int idx , int n, int prev , int prevCount, int k){
        if(prevCount == 3){
            return 0;
        }
        if(idx == n){
            return 1;
        }
        if(dp[prevCount][idx][k] != null){
            return dp[prevCount][idx][k];
        }
        int ans = 0;
        for(int i = 1 ; i <= k ; i++){
            if(prev == i)
            ans = ans + helper(idx + 1 , n , i , prevCount + 1 ,k);
            else
            ans = ans + helper(idx + 1 , n , i , 1 , k);
        }
        return dp[prevCount][idx][k] = ans;
    }
    public int numWays(int n, int k) {
        dp = new Integer[3][n][k + 1];
        int ans = helper(0,n,0,0,k);
        return ans;
    }
}