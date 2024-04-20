class Solution {
    List<int []> ans;
    boolean visited[][];
    int last[];
    private void dfsTraversal(int x,int y,int grid[][]){
        if(x < 0 || y < 0 || grid.length == x || grid[0].length == y ||  grid[x][y] == 0){
            return;
        }
        if(visited[x][y]){
            return;
        }
        last[0] = Math.max(last[0],x);
        last[1] = Math.max(last[1],y);
        visited[x][y] = true;
        dfsTraversal(x + 1 , y , grid);
        dfsTraversal(x , y + 1 , grid);
    }
    public int[][] findFarmland(int[][] land) {
        ans = new ArrayList<>();
        visited = new boolean[land.length][land[0].length];
        for(int i = 0 ; i < land.length ; i++){
            for(int j = 0 ; j < land[i].length ; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    last = new int[2];
                    dfsTraversal(i,j,land);
                    int curr[] = new int[4];
                    curr[2] = last[0];
                    curr[3] = last[1];
                    curr[0] = i;
                    curr[1] = j;
                    ans.add(curr);
                    System.out.println(Arrays.toString(last));
                }
            }
        }
        int res[][] = new int[ans.size()][];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}