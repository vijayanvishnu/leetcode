class Solution {
    Map<String,Integer> dp;
    private int helper(int curr,int jumps,int target,int moveDown){
        int ans = 0;
        if(curr < 0){
            return 0;
        }
        String key = curr + "-" + jumps+"-" + moveDown;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        if(curr == target){
            ans++;
        }
        if(moveDown == 0){
            ans = ans + helper(curr - 1, jumps , target, 1);
        }
        if((target < curr && curr - target <= 1) || target >= curr){
            ans = ans + helper(curr + (1 << jumps) , jumps + 1 , target , 0);
        }
        dp.put(key,ans);
        return ans;
    }
    public int waysToReachStair(int k) {
        dp = new HashMap<>();
        int ans = helper(1,0,k,0);
        return ans;
    }
}