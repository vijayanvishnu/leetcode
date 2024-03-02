class Solution {
    private int helper(int idx , int n,int visited){
        if(idx == n + 1){
            return 1;
        }
        int ans = 0;
        for(int i = 1 ; i <=  n; i++){
            if((visited & (1 << i)) == 0 && (idx%i == 0 || i%idx == 0)){
                ans = ans + helper(idx + 1, n ,(visited | (1 << i)));
            }
        }
        return ans;
    }
    public int countArrangement(int n) {
        return helper(1,n,0);
    }
}