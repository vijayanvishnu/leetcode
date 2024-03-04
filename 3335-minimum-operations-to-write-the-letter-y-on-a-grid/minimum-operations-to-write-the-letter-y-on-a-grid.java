class Solution {
    public int minimumOperationsToWriteY(int[][] matrix) {
        Map<Integer,Integer> yHash = new HashMap<>();
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < 3 ; i++){
            yHash.put(i,0);
            hash.put(i,0);
        }
        boolean visited[][] = new boolean[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length ; i++){
            int x = i;
            int y = matrix.length - 1 - i;
            yHash.put(matrix[x][x] , yHash.get(matrix[x][x]) + 1);
            if(x != y)
            yHash.put(matrix[x][y] , yHash.get(matrix[x][y]) + 1);
            visited[x][y] = true ;
            visited[x][x] = true ;
            if(x == y){
                break;
            }

        }
        for(int i = matrix.length / 2 ; i < matrix.length ; i++){
            int key = matrix[i][matrix.length/2];
            if(!visited[i][matrix.length/2])
            yHash.put(key , yHash.get(key) + 1);
            visited[i][matrix.length / 2] = true;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix.length ; j++){
                if(!visited[i][j]){
                    hash.put(matrix[i][j],hash.get(matrix[i][j]) + 1);
                }
            }
        }
        for(int i = 0; i <  3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(i == j){
                    continue;
                }
                int yCh = 0;
                for(Map.Entry<Integer,Integer> entry : yHash.entrySet()){
                    int key = entry.getKey();
                    if(key != i){
                        yCh += entry.getValue();
                    }
                }
                int ch = 0;
                for(Map.Entry<Integer,Integer> entry : hash.entrySet()){
                    int key = entry.getKey();
                    if(key != j){
                        yCh += entry.getValue();
                    }
                }
                ans = Math.min(ans,ch + yCh);
            }
        }
        return ans;
    }
}