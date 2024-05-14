class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int min[][] = new int[m + 1][n + 1];
        Arrays.fill(min[0],Integer.MAX_VALUE/2);
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ;i <= m ; i++){
            min[i][0] = Integer.MAX_VALUE/2;
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                min[i + 1][j + 1] = Math.min(grid.get(i).get(j),Math.min(min[i][j + 1],min[i + 1][j]));
            }
            for(int j = 0 ; j < n ; j++){
                int curr = grid.get(i).get(j);
                ans = Math.max(ans,Math.max(curr - min[i + 1][j],curr- min[i][j+1]));
            }
        }
        return ans;
    }
}