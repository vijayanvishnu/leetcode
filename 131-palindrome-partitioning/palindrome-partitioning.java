class Solution {
    List<List<String>> res;
    private void backtrack(int start,String s,boolean dp[][],LinkedList<String> list){
        if(start >= s.length()){
            res.add(new ArrayList<>(list));
        }
        for(int i = start ; i < s.length() ; i++){
            if(dp[start][i]){
                list.add(s.substring(start,i+1));
                backtrack(i+1, s, dp, list);
                list.pollLast();
            }
        }
    }
    public List<List<String>> partition(String s) {
        // odd length
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            int left = i;
            int right = i;
            while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
                dp[left][right] = true;
                left--;
                right++;
            }
        }
        // even length
        for(int i = 1 ; i < s.length() ; i++){
            int left = i-1;
            int right = i;
            while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
                dp[left][right] = true;
                left--;
                right++;
            }
        }
        res = new LinkedList<>();
        backtrack(0, s, dp, new LinkedList<>());
        return res;
    }
}