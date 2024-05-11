class Solution {
    private long helper(int nums[][]){
        long row[] = new long[nums[0].length];
        long ans = 0;
        long col[] = new long[nums[0].length + 1];
        for(int i = 0 ; i < nums.length ; i++){
            Arrays.fill(col,0);
            for(int j = nums[i].length - 1 ; j > -1 ; j--){
                col[j] = col[j + 1] + (nums[i][j] == 1 ? 1 : 0);
            }
            for(int j = 0 ; j < nums[i].length ; j++){
                if(nums[i][j] == 1){
                    ans = ans + col[j + 1] * row[j];
                    row[j]++;
                }
            }
        }
        return ans;
    }
    public long numberOfRightTriangles(int[][] grid) {
        long ans1 = helper(grid);
        for(int i = 0 ;i < grid.length ; i++){
            int l = 0;
            int r = grid[i].length - 1;
            while(l < r){
                int t = grid[i][l];
                grid[i][l]  = grid[i][r];
                grid[i][r]  = t;
                l++;
                r--;
            }
        }
        long ans2 = helper(grid);
        int l = 0;
        int r = grid.length - 1;
        while(l < r){
            int t[] = grid[l];
            grid[l] = grid[r];
            grid[r] = t;
            l++;
            r--;
        }
        long ans3 = helper(grid);

        for(int i = 0 ;i < grid.length ; i++){
            l = 0;
            r = grid[i].length - 1;
            while(l < r){
                int t = grid[i][l];
                grid[i][l]  = grid[i][r];
                grid[i][r]  = t;
                l++;
                r--;
            }
        }
        long ans4 = helper(grid);
        return ans3 + ans4 + ans1 + ans2;
    }
}