class Solution {
    // get min and shifts needed to do it within k
    // will it be moved to a , if yes do it else go k prev.
    static int dp[][] = new int[26][26];
    static {
        for(int i = 0 ; i < 26 ; i++){
            int dis = 0;
            while(dis < 26){
                dp[i][(i + dis) % 26] = dis;
                dis++;
            }
            dis = 0;
            int j = i;
            while(dis < 26){
                dp[i][j] = Math.min(dis,dp[i][j]);
                j--;
                if(j == -1){
                    j = 25;
                }
                dis++;
            }
        }
    }
    public String getSmallestString(String s, int k) {
        char str[] = s.toCharArray();
        for(int i = 0 ; i < str.length ; i++){
            int dis = str[i] - 'a';
            for(int j = 0 ; j < dis ; j++){
                if(k >= dp[j][dis]){
                    k -= dp[j][dis];
                    str[i] = (char) (j + 'a');
                    break;
                }
            }
        }
        return new String(str);
    }
}