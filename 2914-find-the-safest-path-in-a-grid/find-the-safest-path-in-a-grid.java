class Solution {
    private boolean bfsScan(int grid[][],int dis){
        Queue<int []> queue = new LinkedList<>();
        int n = grid.length;
        int dir[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean visited[][] = new boolean[n][n];
        visited[0][0] = true;
        if(grid[0][0] >= dis)
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int poll[] = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if(x == n - 1 && y == n - 1){
                return true;
            }
            for(int i[] : dir){
                int ix = x + i[0];
                int iy = y + i[1];
                if(ix < n && iy < n && ix > -1 && iy > -1 && grid[ix][iy] >= dis && !visited[ix][iy]){
                    queue.add(new int[]{ix,iy});
                    visited[ix][iy] = true;
                }
            }
        }
        return false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<int []> queue = new LinkedList<>();
        int n = grid.size();
        int dis[][] = new int[n][n];
        int myMax = Integer.MAX_VALUE;
        int dir[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0 ; i < n ; i++)
        {
            Arrays.fill(dis[i],myMax);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid.get(i).get(j) == 1){
                    queue.add(new int[]{i,j});
                    dis[i][j]  = 0;
                }
            }
        }
        int curr = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int poll[] = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for(int i[] : dir){
                    int ix = x + i[0];
                    int iy = y + i[1];
                    if(ix < n && iy < n && ix > -1 && iy > -1 && dis[ix][iy] == myMax){
                        queue.add(new int[]{ix,iy});
                        dis[ix][iy]  = curr + 1;
                    }
                }
            }
            curr++;
        }
        int left = 0;
        int right = n;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            boolean found = bfsScan(dis,mid);
            if(found){
                ans = Math.max(ans,mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}