class Solution {
    public int nearestExit(char[][] maze, int[] entry) {
        Queue<int []> q = new LinkedList<>();
        int dir[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        q.add(entry);
        maze[entry[0]][entry[1]] = '-';
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int poll[] = q.poll();
                if(poll[0] == 0 || poll[0] == maze.length - 1 || poll[1] == 0 || poll[1] == maze[0].length - 1){
                    if(!(entry[0] == poll[0] && entry[1] == poll[1]))
                    return ans;
                }
                for(int i[] : dir){
                    int x = poll[0] + i[0];
                    int y = poll[1] + i[1];
                    if(x < maze.length && x > -1 && y > -1 && y < maze[0].length && maze[x][y] == '.'){
                        q.add(new int[]{x,y});
                        maze[x][y] = '-';
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}