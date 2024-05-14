class Solution {
    private int toogleRow(int grid[][],int idx){
        int ones = 0;
        for(int i = 0; i < grid[idx].length ; i++){
            if(grid[idx][i] == 1){
                grid[idx][i] = 0;
            }else{
                grid[idx][i] = 1;
                ones++;
            }
        }
        return ones;
    }
    private int toogleCol(int grid[][],int idx){
        int ones = 0;
        for(int i = 0; i < grid.length ; i++){
            if(grid[i][idx] == 1){
                grid[i][idx] = 0;
            }else{
                grid[i][idx] = 1;
                ones++;
            }
        }
        return ones;
    }
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n ; i++){
            int one = toogleCol(grid,i);
            int zero = m - one;
            if(one > zero){
                if(i == 0){
                    for(int j = 0; j < m ; j++){
                        if(grid[j][i] == 0){
                            toogleRow(grid,j);
                        }
                    }
                }
            }else{
                toogleCol(grid,i);
                if(i == 0){
                    for(int j = 0; j < m ; j++){
                        if(grid[j][i] == 0){
                            toogleRow(grid,j);
                        }
                    }
                }
            }
            one = m - toogleCol(grid,i);
            ans = one * ( 1 << (n - i - 1)) + ans;
        }
        return ans;
    }
}