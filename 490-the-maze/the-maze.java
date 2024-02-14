class Solution {
    boolean visited[][];
    public boolean hasPath(int[][] grid, int[] start, int[] destination) {
        visited = new boolean[grid.length][grid[0].length];
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1],0});
        q.add(new int[]{start[0],start[1],1});
        q.add(new int[]{start[0],start[1],2});
        q.add(new int[]{start[0],start[1],3});
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int poll[] = q.poll();
            int x = poll[0];
            int y = poll[1];
            if(x == destination[0] && y == destination[1]){
                return true;
            }
            int dir = poll[2];
            int dx = x;
            int dy = y;
            boolean inside = false;
            while(dir == 0 && dx >= 0 && grid[dx][y] != 1){
                dx--;
                inside = true;
            }
            if(inside && !visited[dx + 1][y]){
                visited[dx + 1][y]= true;
                q.add(new int[]{dx + 1 , y , 2});
                q.add(new int[]{dx + 1 , y , 3});
            }
            dx = x;
            dy = y;
            inside = false;
            while(dir == 1 && dx < grid.length && grid[dx][y] != 1){
                dx++;
                inside = true;
            }
            if(inside && !visited[dx - 1][y]){
                visited[dx - 1][y]= true;
                q.add(new int[]{dx - 1 , y , 2});
                q.add(new int[]{dx - 1 , y , 3});
            }
            dx = x;
            dy = y;
            inside = false;
            while(dir == 2 && dy >= 0 && grid[x][dy] != 1){
                dy--;
                inside = true;
            }
            if(inside && !visited[x][dy + 1]){
                visited[x][dy + 1]= true;
                q.add(new int[]{x , dy + 1 , 0});
                q.add(new int[]{x, dy + 1 , 1});
            }
            dx = x;
            dy = y;
            inside = false;
            while(dir ==3 && dy < grid[0].length && grid[x][dy] != 1){
                dy++;
                inside = true;
            }
            if(inside && !visited[x][dy - 1]){
                visited[x][dy - 1]= true;
                q.add(new int[]{x , dy - 1 , 0});
                q.add(new int[]{x , dy - 1 , 1});
            }
        }
        return false;
    }
}