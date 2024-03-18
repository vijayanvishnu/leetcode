class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> {
            int res = Integer.compare(a[1],b[1]);
            return res;
        });
        int res = 1;
        int s = points[0][1];
        for(int i=0;i<points.length;i++){
            if(s < points[i][0]){
                res++;
                s = points[i][1];
            }
        }
        return res;
    }
}