class Solution {
    private int helper(int x,int y,int grid[][]){
        if(x == -1 || y == -1 || x == grid.length || y == grid[0].length){
            return 0;
        }
        if(grid[x][y] == 0){
            return 0;
        }
        int curr = grid[x][y];
        int ans = 0;
        grid[x][y] = 0;
        ans = helper(x,y-1,grid);
        ans = Math.max(helper(x,y+1,grid),ans);
        ans = Math.max(helper(x-1,y,grid),ans);
        ans = Math.max(helper(x+1,y,grid),ans);
        grid[x][y] = curr;
        return ans + curr;
    }
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for(int i =  0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                ans = Math.max(ans,helper(i,j,grid));
            }
        }
        return ans;
    }
}