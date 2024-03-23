class Solution {
    Integer dp[][];
    private int helper(int left,int right,char str[]){
        if(left >= right){
            return 0;
        }
        if(dp[left][right] != null){
            return dp[left][right];
        }
        int shrinkLR = Integer.MAX_VALUE;
        if(str[left] == str[right]){
            shrinkLR = helper(left + 1, right - 1 , str);
        }
        int shrink = 1 + helper(left + 1, right,str);
        shrink = Math.min(shrink ,1 + helper(left , right - 1, str));
        return dp[left][right] = Math.min(shrink,shrinkLR);
    }
    public int minInsertions(String s) {
        dp = new Integer[s.length()][s.length()];
        return helper(0,s.length() - 1,s.toCharArray());
    }
}