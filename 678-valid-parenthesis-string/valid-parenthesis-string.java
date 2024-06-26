class Solution {
    Boolean dp[][];
    private boolean helper(int open,int close,int idx,char str []){
        if(close > open){
            return false;
        }
        if(dp[open - close][idx] != null){
            return dp[open - close][idx];
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
        return dp[open - close][idx] = ans;
    }
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length() + 1][s.length() + 1];
        return helper(0,0,0,s.toCharArray());
    }
}