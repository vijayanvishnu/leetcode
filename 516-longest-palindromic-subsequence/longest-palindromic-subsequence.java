class Solution {
    Integer dp[][];
    private int helper(int ptr_1,int ptr_2,char str1[],char str2[]){
        if(ptr_1 == str1.length || ptr_2 == str2.length){
            return 0;
        }
        if(dp[ptr_1][ptr_2] != null){
            return dp[ptr_1][ptr_2];
        }
        int pick = 0;
        int dontA = 0;
        int dontB = 0;
        if(str1[ptr_1] == str2[ptr_2]){
            pick = 1 + helper(ptr_1 + 1, ptr_2 + 1, str1, str2);
        }else{
            dontA = helper(ptr_1 + 1, ptr_2,str1,str2);
            dontB = helper(ptr_1, ptr_2  + 1,str1,str2);
        }
        return dp[ptr_1][ptr_2] = Math.max(dontA,Math.max(dontB,pick));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char a[] = text1.toCharArray();
        char b[] = text2.toCharArray();
        dp = new Integer[a.length][b.length];
        return helper(0,0,a,b);
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        return longestCommonSubsequence(s, sb.toString());
    }
}