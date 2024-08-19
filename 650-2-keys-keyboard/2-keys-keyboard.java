class Solution {
    static int dp[] = new int[1001];
    static {
        for(int i = 1 ; i < dp.length ; i++){
            dp[i] = i;
        }
        for(int i = 2 ; i < dp.length ; i++){
            int op = dp[i] + 1;
            int curr = 2 * i;
            while(curr < dp.length){
                dp[curr] = Math.min(dp[curr],++op);
                curr = curr + i;
            }
        }
    }
    public int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        return dp[n];
    }
}