class Solution {
    Boolean dp[][][];
    private boolean helper(int open,int close,int idx,char str []){
        if(close > open){
            return false;
        }
        if(dp[close][open][idx] != null){
            return dp[close][open][idx];
        }
        if(idx == str.length){
            if(close == open) return true;
            return false;
        }
        boolean ans = false;
        if(str[idx] == '('){
            ans = ans || helper(open + 1 , close , idx + 1 , str);
        }else if(str[idx]  == ')'){
            ans = ans || helper(open, close + 1, idx + 1 , str);
        }else{
            ans = ans || helper(open , close + 1, idx + 1 , str);
            ans = ans || helper(open + 1, close, idx + 1 , str);
            ans = ans || helper(open , close , idx + 1 , str);
        }
        return dp[close][open][idx] = ans;
    }
    public boolean checkValidString(String s) {
        dp = new Boolean[101][101][101];
        return helper(0,0,0,s.toCharArray());
    }
}