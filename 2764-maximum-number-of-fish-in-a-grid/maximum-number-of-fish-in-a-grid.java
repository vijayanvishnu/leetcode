class Solution {
    boolean dp[][];
    private int helper(int x , int y , int grid[][]){
        if( x < 0 || y < 0 || x ==grid.length || y == grid[0].length || grid[x][y] == 0){
            return 0;
        }
        if(dp[x][y]){
            return 0;
        }
        dp[x][y] = true;
        int up = helper( x - 1, y , grid);
        int down = helper( x + 1, y , grid);
        int right = helper( x, y + 1 , grid);
        int left = helper( x, y -1, grid);
        return grid[x][y] + left + right + up + down;
    }
    public int findMaxFish(int[][] grid) {
        int ans = 0;
        dp = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                ans = Math.max(ans , helper( i , j , grid));
            }
        }
        return ans;
    }
}