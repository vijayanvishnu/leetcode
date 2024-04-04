class Solution {
    public int maxDepth(String s) {
        int open = 0;
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
            }else if(ch == ')'){
                open--;
            }
            ans = Math.max(ans,open);
        }
        return ans;
    }
}