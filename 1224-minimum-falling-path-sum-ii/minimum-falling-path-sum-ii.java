class Solution {
    Integer dp[][];
    private int helper(int x , int y, int nums[][]){
        if(x == nums.length){
            return 0;
        }
        if(dp[x][y] != null) return dp[x][y];
        int ans = Integer.MAX_VALUE / 2;
        for(int i = 0 ; i < nums.length ; i++){
            if(i != y)
            ans = Math.min(ans,nums[x][i] + helper(x + 1 , i , nums));
        }
        return dp[x][y] = ans;
    }
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE / 2;
        dp = new Integer[grid.length][grid.length];
        for(int i = 0 ; i < grid.length ; i++){
            ans = Math.min(ans , grid[0][i] + helper(1,i,grid));
        }
        return ans;
    }
}