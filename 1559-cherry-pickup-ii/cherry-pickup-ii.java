class Solution {
    Integer dp[][][];
    private int helper(int i , int j , int l , int grid[][]){
        if(i == grid.length || i < 0 || j == grid[0].length || j < 0 || l == grid[0].length || l < 0){
            return 0;
        }
        if(dp[i][j][l] != null){
            return dp[i][j][l];
        }
        int ans = 0;
        int dir[][] = new int[][]{{1,-1},{1,0},{1,1}};
        for(int x = 0; x < dir.length ; x++){
            int ax = dir[x][0] + i;
            int ay = dir[x][1] + j;
            for(int y = 0; y < dir.length ; y++){
                int bx = dir[y][0] + i;
                int by = dir[y][1] + l;
                if(ay == by){
                    continue;
                }
                int a = grid[i][j] + grid[i][l] + helper(ax,ay,by,grid);
                ans = Math.max(ans,a);
            }
        }
        return dp[i][j][l] = ans;
    }
    public int cherryPickup(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return helper(0,0,grid[0].length - 1,grid);
    }
}