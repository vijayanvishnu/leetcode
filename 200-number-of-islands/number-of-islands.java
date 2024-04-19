class Solution {
    boolean visited[][] = null;
    private void bfsTraversal(char grid[][], int x,int y){
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || visited[x][y] || grid[x][y]=='0'){
            return;
        }
        visited[x][y] = true;
        bfsTraversal(grid,x+1,y);
        bfsTraversal(grid,x-1,y);
        bfsTraversal(grid,x,y+1);
        bfsTraversal(grid,x,y-1);
    }
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    res++;
                    bfsTraversal(grid,i,j);
                }
            }
        }
        return res;
    }
}