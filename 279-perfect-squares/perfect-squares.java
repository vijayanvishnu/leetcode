class Solution {
    int myMax = 1_000_00;
    Integer dp[];
    static ArrayList<Integer> list = new ArrayList<>();
    static{
        int size = 1_000_1;
        for(int i=1;i*i<size;i++){
            list.add(i*i);
        }
    }
    private int helper(ArrayList<Integer> l,int balance){
        if(balance == 0){
            return 0;
        }
        if(balance < 0){
            return myMax;
        }
        if(dp[balance] != null) return dp[balance];
        int res = myMax;
        for(int i=list.size()-1;i>=0;i--){
            res = Math.min(res,1+helper(l, balance - l.get(i)));
        }
        return dp[balance] = res;
    }
    public int numSquares(int n) {
        dp = new Integer[n+1];
        return helper(list,n);
    }
}