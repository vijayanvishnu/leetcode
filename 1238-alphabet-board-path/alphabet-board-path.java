class Solution {
    static String path[][] = new String[26][26];
    static Map<Integer,String> mp = new HashMap<>();
    static int dir[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}}; 
    static{
        mp.put(0,"U");
        mp.put(1,"D");
        mp.put(2,"R");
        mp.put(3,"L");
        String boards[] = new String[]{"abcde","fghij","klmno","pqrst","uvwxy","z0000"};
        char grid[][] = new char[6][];
        for(int i = 0 ; i < boards.length ; i++){
            grid[i] = boards[i].toCharArray();
        }
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                bfsTraversal(grid,i,j);
            }
        }
    }
    static void bfsTraversal(char grid[][],int x,int y){
        if(grid[x][y] == '0'){
            return;
        }
        int start = grid[x][y] - 'a';
        boolean visited[][] = new boolean[6][5];
        visited[x][y] = true;
        Queue<Object []> q = new LinkedList<>();
        q.add(new Object[]{x,y,new StringBuilder()});
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Object poll[] = q.poll();
                Integer int_x = (Integer) poll[0];
                Integer int_y = (Integer) poll[1];
                StringBuilder sb = (StringBuilder) poll[2];
                int c = 0;
                for(int itr[] : dir){
                    int i = int_x + itr[0];
                    int j = int_y + itr[1];
                    if(i > -1 && j > -1 && i < grid.length && j < grid[0].length  && !visited[i][j] && grid[i][j] != '0'){
                        StringBuilder sbb = new StringBuilder(sb);
                        sbb.append(mp.get(c));
                        q.add(new Object[]{i,j,sbb});
                        visited[i][j] = true;
                        int end = grid[i][j] - 'a';
                        path[start][end] = sbb.toString();
                    }
                    c++;
                }
            }
        }
    }
    public String alphabetBoardPath(String target) {
        String s = "a" + target;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            int start = s.charAt(i-1) - 'a';
            int end = s.charAt(i) - 'a';
            String key = path[start][end];
            if(key != null)
            sb.append(key);
            sb.append("!");
        }
        return sb.toString();
    }
}