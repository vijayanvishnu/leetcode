class Solution {
    Boolean dp[][];
	private boolean helper(char a[],char b[],char c[],int aIdx,int bIdx,int cIdx) {
		if(cIdx == c.length) {
			return true;
		}
		if(dp[aIdx][bIdx] != null) {
			return dp[aIdx][bIdx];
		}
		boolean ans = false;
		if(aIdx < a.length && c[cIdx] == a[aIdx]) {
			ans = helper(a,b,c,aIdx + 1 , bIdx , cIdx + 1);
		}
		if(bIdx < b.length && c[cIdx] == b[bIdx]) {
			ans = ans || helper(a,b,c,aIdx, bIdx + 1, cIdx + 1);
		}
		return dp[aIdx][bIdx] =ans;
	}
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[101][101];
        return helper(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,0);
    }
}