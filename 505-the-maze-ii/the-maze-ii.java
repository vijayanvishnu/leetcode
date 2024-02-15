class Solution {
    public int shortestDistance(int[][] grid, int[] start, int[] destination) {
        Queue<int []> q = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        q.add(new int[]{start[0],start[1],0,0});
        q.add(new int[]{start[0],start[1],1,0});
        q.add(new int[]{start[0],start[1],2,0});
        q.add(new int[]{start[0],start[1],3,0});
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int poll[] = q.poll();
                int x = poll[0];
                int y = poll[1];
                int dir = poll[2];
                int c = poll[3];
                if(dir == 0){
                    if( x == 0 || grid[x - 1][y] == 1){
                        if( x == destination[0] && y == destination[1]){
                            return c;
                        }
                        if(visited[x][y]){
                            continue;
                        }
                        visited[x][y] = true;
                        if(y > 0 && grid[x][y - 1] != 1)
                        q.add(new int[]{x, y - 1 , 2 , c + 1});
                        if(y < grid[0].length - 1 && grid[x][y + 1] != 1)
                        q.add(new int[]{x , y + 1, 3 , c + 1});
                    }else{
                        q.add(new int[]{x - 1, y , 0 , c + 1});
                    }
                }else if(dir == 1){
                    if( x == grid.length - 1 || grid[x + 1][y] == 1){
                        if( x == destination[0] && y == destination[1]){
                            return c;
                        }
                        if(visited[x][y]){
                            continue;
                        }
                        visited[x][y] = true;
                        if(y > 0 && grid[x][y - 1] != 1)
                        q.add(new int[]{x, y - 1 , 2 , c + 1});
                        if(y < grid[0].length - 1 && grid[x][y + 1] != 1)
                        q.add(new int[]{x , y + 1, 3 , c + 1});
                    }else{
                        q.add(new int[]{x + 1, y , 1 , c + 1});
                    }
                }else if(dir == 2){
                    if( y == 0 || grid[x][y - 1] == 1){
                        if( x == destination[0] && y == destination[1]){
                            return c;
                        }
                        if(visited[x][y]){
                            continue;
                        }
                        visited[x][y] = true;
                        if(x > 0 && grid[x - 1][y] != 1)
                        q.add(new int[]{x - 1, y , 0 , c + 1});
                        if(x < grid.length - 1 && grid[x + 1][y] != 1)
                        q.add(new int[]{x + 1, y, 1 , c + 1});
                    }else{
                        q.add(new int[]{x, y - 1 , 2 , c + 1});
                    }
                }else{
                    if( y == grid[0].length - 1 || grid[x][y + 1] == 1){
                        if( x == destination[0] && y == destination[1]){
                            return c;
                        }
                        if(visited[x][y]){
                            continue;
                        }
                        visited[x][y] = true;
                        if(x > 0 && grid[x - 1][y] != 1)
                        q.add(new int[]{x - 1, y , 0 , c + 1});
                        if(x < grid.length - 1 && grid[x + 1][y] != 1)
                        q.add(new int[]{x + 1, y, 1 , c + 1});
                    }else{
                        q.add(new int[]{x, y + 1, 3 , c + 1});
                    }
                    
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}