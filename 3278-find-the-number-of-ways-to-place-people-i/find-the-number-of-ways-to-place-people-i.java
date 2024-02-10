class Solution {
    public int numberOfPairs(int[][] points) {
        int ans = 0;
        for(int  i = 0; i < points.length ; i++){
            for(int j = 0 ; j < points.length ; j++){
                if(i == j || points[i][0] > points[j][0] || points[j][1] > points[i][1]){
                    continue;
                }
                boolean found = true;
                for(int k = 0 ; k < points.length ; k++){
                    if(k == i || k == j){
                        continue;
                    }
                    if(points[i][0] <= points[k][0] && points[k][0] <= points[j][0] && points[i][1] >= points[k][1] && points[j][1] <= points[k][1]){
                        found = false;
                    }
                }
                if(found) ans++;
            }
        }
        return ans;
    }
}