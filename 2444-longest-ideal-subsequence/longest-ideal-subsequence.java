class Solution {
    public int longestIdealString(String s, int k) {
        int dp[] = new int[26];
        int ans = 0;
        for(int i = s.length() - 1 ; i > -1 ; i--){
            int key = s.charAt(i) - 'a';
            int low = Math.max(0,key - k);
            int high = Math.min(25,key + k);
            int curr = 0;
            while(low <= high){
                curr = Math.max(curr,dp[low]);
                low++;
            }
            dp[key] = Math.max(curr + 1 , dp[key]);
            ans = Math.max(ans,dp[key]);
        }
        return ans;
    }
}