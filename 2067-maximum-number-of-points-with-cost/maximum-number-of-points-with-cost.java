class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long ans = 0;
        long dp[][] = new long[m][n];
        for(int i = 0 ; i < n ; i++){
            dp[m - 1][i] = points[m - 1][i];
        }
        for(int i = m - 2 ; i > -1 ; i--){
            int idx = 0;
            long sum = Integer.MIN_VALUE;
            for(int j = 0 ; j < n ; j++){
                if(sum - Math.abs(idx - j) < dp[i + 1][j]){
                    sum = dp[i + 1][j];
                    idx = j;
                }
                dp[i][j] = Math.max(sum + points[i][j] - Math.abs(idx-j),dp[i][j]);
            }
            idx = n - 1;
            sum = Integer.MIN_VALUE;
            for(int j = n - 1 ; j > -1 ; j--){
                if(sum - Math.abs(idx - j) < dp[i + 1][j]){
                    sum = dp[i + 1][j];
                    idx = j;
                }
                dp[i][j] = Math.max(sum + points[i][j] - Math.abs(idx-j),dp[i][j]);
            }
        }
        for(long i[] : dp){
            System.out.println(Arrays.toString(i));
        }
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans,dp[0][i]);
        }
        return ans;
    }
}