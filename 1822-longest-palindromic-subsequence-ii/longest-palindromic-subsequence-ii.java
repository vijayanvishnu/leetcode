class Solution {
    Integer dp[][][];
    private int helper(char str[],int left,int right,char prev){
        if(left < 0 || right >= str.length){
            return 0;
        }
        if(dp[prev][left][right] != null){
            return dp[prev][left][right];
        }
        if(str[left] == str[right] && left != right && str[left] != prev){
            return dp[prev][left][right] = 2 + helper(str , left - 1, right + 1,str[left]);
        }else{
            int leftMove = helper(str,left - 1, right,prev);
            int rightMove = helper(str,left, right + 1,prev);
            return dp[prev][left][right] = Math.max(leftMove,rightMove);
        }
    }
    public int longestPalindromeSubseq(String s) {
        int ans = 0;
        dp = new Integer[126][s.length()][s.length()];
        char str[] = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i++){
            ans = Math.max(ans,helper(str,i,i,'0'));
        }
        return ans;
    }
}