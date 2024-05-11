class Solution {
    private int helper(int points[][] , char str[] , int a){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < points.length ; i++){
            int x = Math.abs(points[i][0]);
            int y = Math.abs(points[i][1]);
            if(x <= a && y <= a){
                if(set.contains(str[i])){
                    return -1;
                }
                set.add(str[i]);
            }
        }
        return set.size();
    }
    public int maxPointsInsideSquare(int[][] points, String s) {
        int left = 0;
        int right = 1_00_000_000_1;
        int ans = 0;
        char str[]  = s.toCharArray();
        while(left <= right){
            int mid = left + (right - left) / 2;
            int count = helper(points,str,mid);
            if(count == -1){
                right = mid - 1;
            }else{
                ans = Math.max(ans,count);
                left = mid + 1;
            }
        }
        return ans;
    }
}