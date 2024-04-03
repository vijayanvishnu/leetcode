class Solution {
    private boolean backtrack(char grid[][],int x,int y,char target[],int idx){
        if(idx==target.length){
            return true;
        }
        if(x<0 || x>= grid.length || y<0 || y>=grid[0].length){
            return false;
        }
        if(target[idx]!=grid[x][y]){
            return false;
        }
        boolean res = false;
        grid[x][y] = '-';
        res = backtrack(grid,x+1,y,target,idx+1);
        grid[x][y] = target[idx];
        grid[x][y] = '-';
        res = res || backtrack(grid,x-1,y,target,idx+1);
        grid[x][y] = target[idx];
        grid[x][y] = '-';
        res = res || backtrack(grid,x,y+1,target,idx+1);
        grid[x][y] = target[idx];
        grid[x][y] = '-';
        res = res || backtrack(grid,x,y-1,target,idx+1);
        grid[x][y] = target[idx];
        return res;
    }
    public boolean exist(char[][] grid, String word) {
        char wordArray[] = word.toCharArray();
        Set<String> set = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(backtrack(grid,i,j,wordArray,0)){
                    return true;
                }
            }
        }
        return false;
    }
}